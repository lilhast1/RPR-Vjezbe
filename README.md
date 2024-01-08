
Smjer komunikacije:

=put podataka ka korisnik
==geografija.db->GeografijaDAO->glavna.fxml
==geografija.db->GeografijaDAO->gradovi.fxml
==geografija.db->GeografijaDAO->drzave.fxml

=put podataka od korisnika
==glavna.fxml->GlavniController->GeografijaDAO->geografija.db
==gradovi.fxml->GradoviController->GeografijaDAO->geografija.db
==drzave.fxml->DrzaveController->GeografijaDAO->geografija.db
