import React, { useEffect, useState } from "react";
import { Table, Button, Form, ButtonGroup} from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import TestAxios from "../../apis/TestAxios";

const Ljubimci = () => {
  
  const [ljubimci, setLjubimci] = useState([])
  const [kategorije, setKategorije] = useState([])
  const [search, setSearch] = useState({ kategorijaId: -1, pol: "", opis: ""})
  const [pageNo, setPageNo] = useState(0)
  const [totalPages, setTotalPages] = useState(1)
  const navigate = useNavigate()

  useEffect(()=>{
    getData();
  }, [])

  const getData = () => {
    getKategorije();
    getLjubimci(0);
  }

  const getLjubimci = (page) => {
    let config = { params: {
      pageNo: page
    } };

    //Sledeca 3 if-a su tu zbog search-a
    if (search.kategorijaId != -1) {
      config.params.kategorijaId = search.kategorijaId;
    }
    if (search.pol != "") {
      config.params.pol = search.pol;
    }
    
    if (search.opis != "") {
      config.params.opis = search.opis;
    }

    TestAxios.get("/ljubimci", config)
    .then((result)=>{
      setPageNo(page)
      setLjubimci(result.data)
      setTotalPages(result.headers["total-pages"])
    }).catch(()=>{
      alert("Nije uspelo dobavljanje.");
    })
  }

  const getKategorije = () => {
    TestAxios.get("/kategorije").then((result) => {
      setKategorije(result.data)
    }).catch(()=>{
      alert("Nije uspelo dobavljanje.");
    })
  }

  const goToAdd = () => {
    navigate("/ljubimci/add");
  }

  const doUdomi = (ljubimacId) => {
    TestAxios.put("/udomljavanje/" + ljubimacId)
    .then(()=>{
      // metoda za get svih ljubimaca
      getLjubimac(pageNo);
    }).catch(() =>{
      alert("Nije uspelo dodavanje.");
    })
  }

  const doDelete = (ljubimacId) => {
      TestAxios.delete("/ljubimci/" + ljubimacId)
      .then(()=>{
        var nextPage
        if(pageNo==totalPages-1 && ljubimci.length==1){
          nextPage = pageNo-1
        }else{
          nextPage = pageNo
        }
        getLjubimci(nextPage);
      }).catch((error) => {
        alert("Nije uspelo brisanje.");
      })
  }

  const searchValueInputChange = (event) => {
    let newSearch = {...search}

    const name = event.target.name;
    const value = event.target.value;

    newSearch[name] = value
    setSearch(newSearch);
  }

  const doSearch = () => {
    getLjubimci(0);
  }

  const renderHeader = () => {
    const admin = window.localStorage['role']=="ROLE_ADMIN";
    return  <tr>
    <th>Ime</th>
    <th>Starost (broj meseci)</th>
    <th>Vakcinisan</th>
    <th>Pol</th>
    <th>Tezina (kg)</th>
    <th>Opis</th>
    <th>Kategorija</th>
    <th hidden={!admin}></th>
    <th hidden={admin}></th>
  </tr>;
  }

  const renderBody = () => {
    const admin = window.localStorage['role']=="ROLE_ADMIN";
    return ljubimci.map((ljubimac) => {
    return <tr key={ljubimac.id}>
        <td>{ljubimac.ime}</td>
        <td>{ljubimac.starost}</td>
        <td>{ljubimac.vakcinisan ? "Vakcinisan" : "Nije vakcinisan"}</td>
        <td>{ljubimac.pol}</td>
        <td>{ljubimac.tezina}</td>
        <td>{ljubimac.opis}</td>
        <td>{ljubimac.kategorijaIme}</td>
        <td hidden={!admin}> 
          <Button
            variant="danger"
            onClick={() => doDelete(ljubimac.id)}
            style={{ marginLeft: 5 }}>
            Obrisi
          </Button>
        </td>
        <td hidden={admin}> 
        <Button
          variant="info"
          onClick={() => doUdomi(ljubimac.id)}
          style={{ marginLeft: 5 }}>
          Udomi
        </Button>
        </td>
      </tr>
  })}


  return (
    <div>
      <h1>Ljubimci</h1>
      {/*Deo za Search*/}
      <Form style={{marginTop:10}}>
      <Form.Group>
          <Form.Label>Kategorija ljubimca</Form.Label>
          <Form.Control
            onChange={(event) => searchValueInputChange(event)}
            name="kategorijaId"
            value={search.kategorijaId}
            as="select">
            <option value={-1}>Izaberi kategoriju</option>
            {kategorije.map((kategorija) => {
              return (
                <option value={kategorija.id} key={kategorija.id}>
                  {kategorija.naziv}
                </option>
              );
            })}
          </Form.Control>
        </Form.Group>
        </Form>
        <Form style={{marginTop:10}}>
      <Form.Group>
          <Form.Label>Pol</Form.Label>
          <Form.Control
            onChange={(event) => searchValueInputChange(event)}
            name="pol"
            value={search.pol}
            as="select">
            <option value={-1}>Izaberi pol</option>
            {ljubimci.map((ljubimac) => {
              return (
                <option value={ljubimac.pol} key={ljubimac.pol}>
                  {ljubimac.pol}
                </option>
              );
            })}
          </Form.Control>
        </Form.Group>
        <Form.Group>
          <Form.Label>Opis</Form.Label>
          <Form.Control
            value={search.opis}
            placeholder="Opis"
            name="opis"
            as="input"
            onChange={(e) => searchValueInputChange(e)}
          ></Form.Control>
        </Form.Group>
        <Button onClick={() => doSearch()}>Pretraga</Button>
      </Form>
      
      {/*Deo za ADD dugme*/}
      {window.localStorage['role']=="ROLE_ADMIN"?
      <ButtonGroup style={{ marginTop: 25, float:"left"}}>
        <Button variant="info" onClick={() => goToAdd()}>
          Kreiraj ljubimac
        </Button>
      </ButtonGroup>
      :null} 
        {/*Deo za prikaz Ljubimci*/}
      <ButtonGroup style={{ marginTop: 25, float:"right"}}>
        <Button 
          style={{ margin: 3, width: 90}}
          disabled={pageNo==0} onClick={()=>getLjubimci(pageNo-1)}>
          Prethodna
        </Button>
        <Button
          style={{ margin: 3, width: 90}}
          disabled={pageNo==totalPages-1} onClick={()=>getLjubimci(pageNo+1)}>
          Sledeca
        </Button>
      </ButtonGroup>
      {/* Tabela za prikaz ljubimci */}
      <Table bordered striped style={{ marginTop: 5 }}>
        <thead className="thead-dark">
          {renderHeader()}
        </thead>
        <tbody>
          {renderBody()} 
        </tbody>
      </Table>
    </div>
  );
}

export default Ljubimci
