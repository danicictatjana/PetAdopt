INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');

INSERT INTO kategorija (id, naziv) VALUES (1, 'pas');
INSERT INTO kategorija (id, naziv) VALUES (2, 'macka');
INSERT INTO kategorija (id, naziv) VALUES (3, 'ptica');

INSERT INTO ljubimac (id, ime, opis, pol, starost, tezina, vakcinisan, kategorija_id) VALUES (1, 'Carli', 'Nemacki ovcar, prijateljski nastrojen', 'muski', 10, 10.00, true, 1);
INSERT INTO ljubimac (id, ime, opis, pol, starost, tezina, vakcinisan, kategorija_id) VALUES (2, 'Bagira', 'Crna macka, umiljata, voli sunce i toplotu', 'zenski', 36, 2.00, false, 2);
INSERT INTO ljubimac (id, ime, opis, pol, starost, tezina, vakcinisan, kategorija_id) VALUES (3, 'Sebastijan', 'Plavo-zuti papagaj koju smo videli na reklamama za kafu', 'muski', 3, 0.5, true, 3);

INSERT INTO udomljavanje (id, datum_vreme, ljubimac_id) VALUES (1, '2023-03-20 07:00', 1);
INSERT INTO udomljavanje (id, datum_vreme, ljubimac_id) VALUES (2, '2022-03-20 07:00', 2);
INSERT INTO udomljavanje (id, datum_vreme, ljubimac_id) VALUES (3, '2021-03-20 07:00', 3);