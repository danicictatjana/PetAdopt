import React, { useEffect, useState } from "react";
import { Button, Form} from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import TestAxios from "../../apis/TestAxios";

const LjubimacAadd = () => {
  //potrebno je zbog create-a
  const emptyLjubimac = {
    ime: "",
    starost: "",
    pol: "",
    tezina: "",
    opis: "",
    kategorijaId: -1
  }
  const [ljubimac, setLjubimac] = useState(emptyLjubimac)
  const [kategorije, setKategorije] = useState([])
  const navigate = useNavigate()

  useEffect(()=>{
    getData();
  }, [])

  const getData = () => {
    getKategorije();
  }

  const getKategorije = () => {
    TestAxios.get("/kategorije").then((result) => {
      setKategorije(result.data)
    }).catch(()=>{
      alert("Nije uspelo dobavljanje.");
    })
  }

  const doAdd = () => {
    TestAxios.post("/ljubimci/", ljubimac)
    .then(()=>{
      //bitno je da bi "resetovali" polja za kreiranje nakon kreiranja
      let ljubimac = {
        ime: "",
        starost: "",
        pol: "",
        tezina: "",
        opis: "",
        kategorijaId: -1
      };
      setLjubimac(ljubimac)
      navigate("/ljubimci");
    }).catch(() =>{
      alert("Nije uspelo dodavanje.");
    })
  }

  const addValueInputChange = (event) => {
    let noviLjubimac = {...ljubimac}

    const name = event.target.name;
    const value = event.target.value;
    
    noviLjubimac[name] = value
    setLjubimac(noviLjubimac);
  }

  const canCreateLjubimac = () => {
    return ljubimac.ime!="" && 
      ljubimac.starost!="" && ljubimac.tezina>0 && ljubimac.pol!="" && ljubimac.opis!="" &&
      ljubimac.kategorijaId != -1
  }

  return (
    <div>
      {/*Deo za ADD*/}
      <Form>
        <Form.Group>
          <Form.Label>Ime</Form.Label>
          <Form.Control
            onChange={(event) => addValueInputChange(event)}
            placeholder="Ime ljubimca"
            name="ime"
            value={ljubimac.ime}
            as="input"
          ></Form.Control>
        </Form.Group>
        <Form.Group>
          <Form.Label>Starost</Form.Label>
          <Form.Control
            onChange={(event) => addValueInputChange(event)}
            placeholder="Starost (broj meseci)"
            name="starost"
            value={ljubimac.starost}
            as="input">
          </Form.Control>
        </Form.Group>
        <Form.Group>
          <Form.Label>Pol</Form.Label>
          <Form.Control
            onChange={(event) => addValueInputChange(event)}
            name="pol"
            value={ljubimac.pol}
            as="select">
            <option value={-1}>Izaberi pol ljubimca</option>
            <option value="muski">muski</option>
            <option value="zenski">zenski</option>
          </Form.Control>
        </Form.Group>
        <Form.Group>
          <Form.Label>Tezina</Form.Label>
          <Form.Control
            onChange={(event) => addValueInputChange(event)}
            placeholder="Tezina (kg)"
            name="tezina"
            value={ljubimac.tezina}
            as="input">
          </Form.Control>
        </Form.Group>
        <Form.Group style={{ float:"left"}}>
          <Form.Label>Opis</Form.Label>
          <Form.Control
            onChange={(event) => addValueInputChange(event)}
            placeholder="Opis ljubimca"
            name="opis"
            value={ljubimac.opis}
            as="textarea"
          ></Form.Control>
        </Form.Group>
        <Form.Group>
          <Form.Label>Kategorija</Form.Label>
          <Form.Control
            onChange={(event) => addValueInputChange(event)}
            name="kategorijaId"
            value={ljubimac.kategorijaId}
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
        <Button disabled = {!canCreateLjubimac()} variant="primary" onClick={() => doAdd()}>
          Dodaj ljubimca
        </Button>
      </Form>
    </div>
  );
}

export default LjubimacAadd
