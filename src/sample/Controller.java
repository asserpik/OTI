package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public class Controller {

    // Luodaan tarvittavat elementit ja listat




    // MÖKIN VARAUS
    public ComboBox cboxToimintaalue;
    public ComboBox cboxHenkilomaara;
    public ComboBox cboxPalvelut;
    public ComboBox cboxMokki;
    //public ComboBox cboxToimintaalue2;
    public ComboBox cboxToimintaalue3;
    public DatePicker dptulopaiva;
    public DatePicker dplahtopaiva;
    public ObservableList<String>toimintaaluelista = FXCollections.observableArrayList("Tahko", "Ruka", "Ylläs", "Himos", "Levi", "Koli", "Vuokatti", "Pallas");
    public ObservableList<String>henkilomaaralista = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","yli 10");
    public ObservableList<String>palvelulista = FXCollections.observableArrayList("Porosafari","Koiravaljakkoajelu","Hevosajelu", "Vesiskootteriajelu","Seikkailupalvelu","Airsoft");
    public ObservableList<String>tahkomokitlista = FXCollections.observableArrayList("Tahko 1", "Tahko 2", "Tahko 3", "Tahko 4", "Tahko 5");
    public ObservableList<String>rukamokitlista = FXCollections.observableArrayList("Ruka 1", "Ruka 2", "Ruka 3", "Ruka 4", "Ruka 5");
    public ObservableList<String>yllasmokitlista = FXCollections.observableArrayList("Ylläs 1", "Ylläs 2", "Ylläs 3", "Ylläs 4", "Ylläs 5");
    public ObservableList<String>himosmokitlista = FXCollections.observableArrayList("Himos 1", "Himos 2", "Himos 3", "Himos 4", "Himos 5");
    public ObservableList<String>levimokitlista = FXCollections.observableArrayList("Levi 1", "Levi 2", "Levi 3", "Levi 4", "Levi 5");
    public ObservableList<String>kolimokitlista = FXCollections.observableArrayList("Koli 1", "Koli 2", "Koli 3", "Koli 4", "Koli 5");
    public ObservableList<String>vuokattimokitlista = FXCollections.observableArrayList("Vuokatti 1", "Vuokatti 2", "Vuokatti 3", "Vuokatti 4", "Vuokatti 5");
    public ObservableList<String>pallasmokitlista = FXCollections.observableArrayList("Pallas 1", "Pallas 2", "Pallas 3", "Pallas 4", "Pallas 5");
    public Text txtVarausVaroitus;

    //MÖKINVARAUS TABLE
    public TableView <Varaus> tvTableView;
    public TableColumn<Varaus, String> tcToimintaalue;
    public TableColumn<Varaus, String> tcTulopaiva;
    public  TableColumn<Varaus, String> tcLahtopaiva;
    public TableColumn<Varaus, String> tcHenkilomaara;
    public TableColumn<Varaus, String> tcAsiakas;
    public TableColumn<Varaus, String> tcPalvelut;
    public TableColumn<Varaus, String> tcMokki;
    public TableColumn<Varaus, String> tcSposti;
    public TableColumn<Varaus, Integer> tcVarausID;

    // MÖKKIENHALLINTA
    //Mökkienhallinta table
    public TableColumn <Mokki, String> CmokkienhallintaNimi;
    public TableColumn <Mokki, String> CmokkienhallintaOsoite;
    public TableColumn <Mokki, String>CmokkienhallintaKuvaus;
    public TableColumn <Mokki, String>CmokkienhallintaHlomaara;
    public TableColumn <Mokki, String>CmokkienhallintaVarustelu;
    public TableColumn <Mokki, String>CmokkienhallintaPostinro;
    public TableColumn <Mokki, Double> CmokkienhallintaHinta;
    public TableColumn <Mokki, Double> CmokkienhallintaAlv;
    public TableColumn <Mokki, Integer>CmokkienhallintaID;

    public TableView tbvMokkienhallintaMokit;

    public TextField txtfMokkienhallintaMokkinimi;
    public TextField txtfMokkienhallintaKatuosoite;
    public TextField txtfMokkienhallintaKuvaus;
    public TextField txtfMokkienhallintaHlomaara;
    public TextField txtfMokkienhallintaVarustelu;
    public TextField txtfMokkienhallintaPostinumero;
    public TextField txtfMokkienhallintaHinta;
    public TextField txtfMokkienhallintaAlv;
    public TextField txtfMokkienhallintaMokkiID;
    public TextField txtfMokkienhallintaTAid;

    // ASIAKASHALLINTA alustus
    public TextField tfEtunimi;
    public TextField tfSukunimi;
    public TextField tfLahiosoite;
    public TextField tfPostinro;
    public TextField tfEmail;
    public TextField tfPuhelinnro;
    public TableView tbvAsiakas;
    public TableColumn tbcEtunimi;
    public TableColumn tbcSukunimi;
    public TableColumn tbcLahiosoite;
    public TableColumn tbcPostinro;
    public TableColumn tbcEmail;
    public TableColumn tbcPuhelinnro;
    public TableColumn tbcAsiakas_id;

    final ObservableList options = FXCollections.observableArrayList();
    final ObservableList listamokkicbox = FXCollections.observableArrayList();
    final ObservableList listaruka = FXCollections.observableArrayList();
    final ObservableList listayllas = FXCollections.observableArrayList();
    final ObservableList listahimos = FXCollections.observableArrayList();
    final ObservableList listalevi = FXCollections.observableArrayList();
    final ObservableList listakoli = FXCollections.observableArrayList();
    final ObservableList listavuokatti = FXCollections.observableArrayList();
    final ObservableList listapallas = FXCollections.observableArrayList();



    // Näyttää toiminta-alueet Palveluiden Hallinta - välilehdellä
    public void NaytaToimintaalue3() {
        cboxToimintaalue3.setItems(toimintaaluelista);
    }


    // Lisätään toiminta-alueet comboboxiin
    public void NaytaToimintaalue() {
        cboxToimintaalue.setItems(toimintaaluelista);
    }

    // Lisätään henkilömäärät comboboxiin
    public void NaytaHenkilomaara(){
        cboxHenkilomaara.setItems(henkilomaaralista);
    }

    public void NaytaPalvelut(){
        cboxPalvelut.setItems(palvelulista);
    }
    public void mokkinimi(InputMethodEvent inputMethodEvent) {
    }

    public void osoite(InputMethodEvent inputMethodEvent) {
    }

    public void postinro(InputMethodEvent inputMethodEvent) {
    }

    public void hlomaara(InputMethodEvent inputMethodEvent) {
    }

    public void kuvaus(InputMethodEvent inputMethodEvent) {
    }

    public void hinta(InputMethodEvent inputMethodEvent) {
    }

    public void alv(InputMethodEvent inputMethodEvent) {
    }

    public void varustelu(InputMethodEvent inputMethodEvent) {
    }

    public void tallennaPalvelu(ActionEvent actionEvent) {
    }

    public void tallennaAsiakas(ActionEvent actionEvent) {
    }


    public void initialize() {
        NaytaToimintaalue();
        //NaytaToimintaalue2();
        NaytaToimintaalue3();
        NaytaHenkilomaara();
        NaytaPalvelut();
        NaytaMokki();
        Varoitus();
        naytaLaskuTiedot();
        //VarausAsiakas();

        SQLYhteys yhteys = new SQLYhteys();
        Connection connectDB = yhteys.getYhteys();
        try{
            String query = "select asiakas_id from asiakas";
            PreparedStatement lause = connectDB.prepareStatement(query);
            ResultSet tulokset = lause.executeQuery();
            while(tulokset.next()){
                options.add(tulokset.getString("asiakas_id"));
            }
            cboxAsiakkaat.setItems(options);
            lause.close();
            tulokset.close();



        }catch (SQLException ex){

        }



        Lasku lasku5 = new Lasku();
        if (lasku5.listaaLaskut() != null) {
            lataaLaskuTaulu();
        }

        //toimii nyt
        Asiakas asiakas = new Asiakas();
        if (asiakas.listaaAsiakkaat() != null) {
            lataaAsiakasTaulu();
        }

        Mokki mokki3 = new Mokki();
        if (mokki3.listaaMokit() != null) {
            lataaMokkiTaulu();
        }

        Varaus varaus = new Varaus();
        if (varaus.listaaVaraukset() != null) {
            lataaVarausTaulu();
        }
    }

    public void lataaLaskuTaulu() {
        //toimii
        tvLasku.getItems().clear();
        Lasku laskuhallinta = new Lasku();
        List<Lasku> laskulista = laskuhallinta.listaaLaskut();
        ObservableList<Lasku> taulunlaskut = FXCollections.observableArrayList(laskulista);

        tcLaskuID.setCellValueFactory(
                new PropertyValueFactory<Lasku, Integer>("lasku_id"));
        tcToimintaalue_Lasku.setCellValueFactory(
                new PropertyValueFactory<Lasku, String>("toimintaalue"));
        tcTulopaiva_Lasku.setCellValueFactory(
                new PropertyValueFactory<Lasku, String>("tulopaiva"));
        tcLahtopaiva_Lasku.setCellValueFactory(
                new PropertyValueFactory<Lasku, String>("lahtopaiva"));
        tcHlomaara_Lasku.setCellValueFactory(
                new PropertyValueFactory<Lasku, Integer>("henkilomaara"));
        tcAsiakas_Lasku.setCellValueFactory(
                new PropertyValueFactory<Lasku, String>("asiakas"));
        tcPalvelut_Lasku.setCellValueFactory(
                new PropertyValueFactory<Lasku, String>("palvelut"));
        tcMokki_Lasku.setCellValueFactory(
                new PropertyValueFactory<Lasku, String>("mokki"));
        tcSposti_Lasku.setCellValueFactory(
                new PropertyValueFactory<Lasku, String>("sposti"));
        tvLasku.setItems(taulunlaskut);
    }

    public void PaivitaLasku() {

        try {

            SQLYhteys connectNow = new SQLYhteys();
            Connection connectDB = connectNow.getYhteys();

            String laskuquery1 = "UPDATE lasku SET toiminta_alue = ?, tulopaiva = ?, lahtopaiva = ?, henkilomaara = ?, asiakas = ?, palvelut = ?, mokki = ?, sposti = ? WHERE varaus_id = ?";

            PreparedStatement preparedStatementl = connectDB.prepareStatement(laskuquery1);
        } catch (Exception e) {
        }
        return;
    }

    ObservableList<Lasku> laskut = FXCollections.observableArrayList();

    public void LisaaLasku(){
        //muuttujat teksikenttien sisällöstä
        String toimintaalue = cboxToimintaalue.getSelectionModel().getSelectedItem().toString();
        String tulopaiva = dptulopaiva.getValue().toString();
        String lahtopaiva = dplahtopaiva.getValue().toString();
        Integer hlomaara = Integer.parseInt(String.valueOf(cboxHenkilomaara.getSelectionModel().getSelectedItem()));
        String asiakas = cboxAsiakkaat.getValue().toString();
        Object mokki = cboxMokki.getSelectionModel().getSelectedItem();
        Object palvelut = cboxPalvelut.getSelectionModel().getSelectedItem();
        String sposti = tfSposti.getCharacters().toString();

        //lisätään taulun sarakkeisiin
        tcToimintaalue_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("toimintaalue"));
        tcTulopaiva_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("tulopaiva"));
        tcLahtopaiva_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("lahtopaiva"));
        tcHlomaara_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, Integer>("henkilomaara"));
        tcAsiakas_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("asiakas"));
        tcMokki_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("mokki"));
        tcPalvelut_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("palvelut"));
        tcSposti_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("sposti"));



        // lisätään Varaus olio, joka lisäätän mökkilistalle
        laskut.add(new Lasku(toimintaalue, tulopaiva, lahtopaiva, hlomaara, asiakas, palvelut, mokki, sposti));

        //lisätään mökkilista taululle

        tvLasku.setItems(laskut);

        //

        //Lisätään tiedot SQL tietokantaan
        try {

            //Sql yhteyden määrittäminen
            SQLYhteys connectNow = new SQLYhteys();
            Connection connectDB = connectNow.getYhteys();

            //Sql lause asiakkaiden luomiselle
            String laskuquery = "insert into lasku (toiminta_alue, tulopaiva, lahtopaiva, henkilomaara, asiakas, palvelut, mokki, sposti )values(?,?,?,?,?,?,?,?)";

            //Preparedstatement määrittää sql lauseen
            PreparedStatement sqllasku = connectDB.prepareStatement(laskuquery);

            //Noudetaan tiedot textfieldistä
            sqllasku.setString(1, cboxToimintaalue.getSelectionModel().getSelectedItem().toString());
            sqllasku.setString(2, dptulopaiva.getValue().toString());
            sqllasku.setString(3, dplahtopaiva.getValue().toString());
            sqllasku.setInt(4, Integer.parseInt(String.valueOf(cboxHenkilomaara.getSelectionModel().getSelectedItem())));
            sqllasku.setString(5, cboxAsiakkaat.getValue().toString());
            sqllasku.setString(6, cboxPalvelut.getSelectionModel().getSelectedItem().toString());
            sqllasku.setString(7, cboxMokki.getSelectionModel().getSelectedItem().toString());
            sqllasku.setString(8, tfSposti.getCharacters().toString());

            //Suoritetaan SQL komennot
            sqllasku.executeUpdate();

            //Kutsutaan metodia, jolla päivitetään tiedot automaattisesti
            PaivitaLasku();

        } catch(Exception e) {
            System.err.println("vahinko");
            System.err.println(e.getMessage());

        }

        Lasku lasku1 = new Lasku();
        if (lasku1.listaaLaskut() != null) {
            lataaLaskuTaulu();
        }
    }



    public void lataaVarausTaulu() {
        //toimii
        tvTableView.getItems().clear();
        Varaus varaushallinta = new Varaus();
        List<Varaus> varauslista = varaushallinta.listaaVaraukset();
        ObservableList<Varaus> taulunvaraukset = FXCollections.observableArrayList(varauslista);

        tcVarausID.setCellValueFactory(
                new PropertyValueFactory<Varaus, Integer>("varaus_id"));
        tcToimintaalue.setCellValueFactory(
                new PropertyValueFactory<Varaus, String>("toimintaalue"));
        tcTulopaiva.setCellValueFactory(
                new PropertyValueFactory<Varaus, String>("tulopaiva"));
        tcLahtopaiva.setCellValueFactory(
                new PropertyValueFactory<Varaus, String>("lahtopaiva"));
        tcHenkilomaara.setCellValueFactory(
                new PropertyValueFactory<Varaus, String>("henkilomaara"));
        tcAsiakas.setCellValueFactory(
                new PropertyValueFactory<Varaus, String>("asiakas"));
        tcPalvelut.setCellValueFactory(
                new PropertyValueFactory<Varaus, String>("palvelut"));
        tcMokki.setCellValueFactory(
                new PropertyValueFactory<Varaus, String>("mokki"));
        tcSposti.setCellValueFactory(
                new PropertyValueFactory<Varaus, String>("sposti"));
        tvTableView.setItems(taulunvaraukset);
    }

    /**
     * MÖKINVARAUSNÄKYMÄ
     */
    public void btPoistaLasku(ActionEvent actionEvent) throws SQLException {
        Lasku poistalasku = new Lasku();
        Lasku valittulasku = (Lasku) tvLasku.getSelectionModel().getSelectedItem();
        Lasku lasku4 = new Lasku();
        lasku4.setLasku_id(valittulasku.getLasku_id());
        poistalasku.PoistaLasku(lasku4.getLasku_id());
        lataaLaskuTaulu();
    }

    public void btVarausPoista(ActionEvent actionEvent) throws SQLException {
        Varaus poistavaraus = new Varaus();
        Varaus valittuvaraus = (Varaus) tvTableView.getSelectionModel().getSelectedItem();
        Varaus varaus4 = new Varaus();
        varaus4.setVaraus_id(valittuvaraus.getVaraus_id());
        poistavaraus.PoistaVaraus(varaus4.getVaraus_id());
        lataaVarausTaulu();
    }


    public void PaivitaVaraus() {

        try {

            SQLYhteys connectNow = new SQLYhteys();
            Connection connectDB = connectNow.getYhteys();

            String varausquery1 = "UPDATE varaus SET toiminta_alue = ?, tulopaiva = ?, lahtopaiva = ?, henkilomaara = ?, asiakas = ?, palvelut = ?, mokki = ?, sposti = ? WHERE varaus_id = ?";

            PreparedStatement preparedStatementv = connectDB.prepareStatement(varausquery1);
        } catch (Exception e) {
        }
        return;
    }

    ObservableList<Varaus> varaukset = FXCollections.observableArrayList();

    public void LisaaVaraus() {

        //muuttujat teksikenttien sisällöstä
        String toimintaalue = cboxToimintaalue.getSelectionModel().getSelectedItem().toString();
        String tulopaiva = dptulopaiva.getValue().toString();
        String lahtopaiva = dplahtopaiva.getValue().toString();
        Integer hlomaara = Integer.parseInt(String.valueOf(cboxHenkilomaara.getSelectionModel().getSelectedItem()));
        String asiakas = cboxAsiakkaat.getValue().toString();
        Object mokki = cboxMokki.getSelectionModel().getSelectedItem();
        Object palvelut = cboxPalvelut.getSelectionModel().getSelectedItem();
        String sposti = tfSposti.getCharacters().toString();

        //lisätään taulun sarakkeisiin
        tcToimintaalue.setCellValueFactory(new PropertyValueFactory<Varaus, String>("toimintaalue"));
        tcTulopaiva.setCellValueFactory(new PropertyValueFactory<Varaus, String>("tulopaiva"));
        tcLahtopaiva.setCellValueFactory(new PropertyValueFactory<Varaus, String>("lahtopaiva"));
        tcHenkilomaara.setCellValueFactory(new PropertyValueFactory<Varaus, String>("henkilomaara"));
        tcAsiakas.setCellValueFactory(new PropertyValueFactory<Varaus, String>("asiakas"));
        tcMokki.setCellValueFactory(new PropertyValueFactory<Varaus, String>("mokki"));
        tcPalvelut.setCellValueFactory(new PropertyValueFactory<Varaus, String>("palvelut"));
        tcSposti.setCellValueFactory(new PropertyValueFactory<Varaus, String>("sposti"));



        // lisätään Varaus olio, joka lisäätän mökkilistalle
        varaukset.add(new Varaus(toimintaalue, tulopaiva, lahtopaiva, hlomaara, asiakas, palvelut, mokki, sposti));

        //lisätään mökkilista taululle

        tvTableView.setItems(varaukset);


        //Lisätään tiedot SQL tietokantaan
        try {

            //Sql yhteyden määrittäminen
            SQLYhteys connectNow = new SQLYhteys();
            Connection connectDB = connectNow.getYhteys();

            //Sql lause asiakkaiden luomiselle
            String varausquery = "insert into varaus (toiminta_alue, tulopaiva, lahtopaiva, henkilomaara, asiakas, palvelut, mokki, sposti )values(?,?,?,?,?,?,?,?)";

            //Preparedstatement määrittää sql lauseen
            PreparedStatement sqlvaraus = connectDB.prepareStatement(varausquery);

            //Noudetaan tiedot textfieldistä
            sqlvaraus.setString(1, cboxToimintaalue.getSelectionModel().getSelectedItem().toString());
            sqlvaraus.setString(2, dptulopaiva.getValue().toString());
            sqlvaraus.setString(3, dplahtopaiva.getValue().toString());
            sqlvaraus.setInt(4, Integer.parseInt(String.valueOf(cboxHenkilomaara.getSelectionModel().getSelectedItem())));
            sqlvaraus.setString(5, cboxAsiakkaat.getValue().toString());
            sqlvaraus.setString(6, cboxPalvelut.getSelectionModel().getSelectedItem().toString());
            sqlvaraus.setString(7, cboxMokki.getSelectionModel().getSelectedItem().toString());
            sqlvaraus.setString(8, tfSposti.getCharacters().toString());

            //Suoritetaan SQL komennot
            sqlvaraus.executeUpdate();

            //Kutsutaan metodia, jolla päivitetään tiedot automaattisesti
            PaivitaVaraus();

        } catch(Exception e) {
            System.err.println("vahinko");
            System.err.println(e.getMessage());

        }

        Varaus varaus1 = new Varaus();
        if (varaus1.listaaVaraukset() != null) {
            lataaVarausTaulu();
        }
    }


    // Antaa valittavaksi mökit siltä toimialueelta, joka näytöllä on valittuna
    public void NaytaMokki() {
        SQLYhteys yhteys = new SQLYhteys();
        Connection connectDB = yhteys.getYhteys();
        cboxToimintaalue.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object vanhaArvo, Object uusiArvo) {
                if (uusiArvo.toString() == "Tahko") {

                    try{
                        String query = "select mokkinimi from mokki where toimintaalue_id = 1;";
                        PreparedStatement lause = connectDB.prepareStatement(query);
                        ResultSet tulokset = lause.executeQuery();
                        while(tulokset.next()){
                            listamokkicbox.add(tulokset.getString("mokkinimi"));
                        }
                        cboxMokki.setItems(listamokkicbox);
                        lause.close();
                        tulokset.close();


                    }catch (SQLException ex){

                    }

                } else if (uusiArvo.toString() == "Ruka") {

                    try{
                        String query = "select mokkinimi from mokki where toimintaalue_id = 2;";
                        PreparedStatement lause = connectDB.prepareStatement(query);
                        ResultSet tulokset = lause.executeQuery();
                        while(tulokset.next()){
                            listaruka.add(tulokset.getString("mokkinimi"));
                        }
                        cboxMokki.setItems(listaruka);
                        lause.close();
                        tulokset.close();


                    }catch (SQLException ex){

                    }

                } else if (uusiArvo.toString() == "Ylläs") {
                    try{
                        String query = "select mokkinimi from mokki where toimintaalue_id = 3;";
                        PreparedStatement lause = connectDB.prepareStatement(query);
                        ResultSet tulokset = lause.executeQuery();
                        while(tulokset.next()){
                            listayllas.add(tulokset.getString("mokkinimi"));
                        }
                        cboxMokki.setItems(listayllas);
                        lause.close();
                        tulokset.close();


                    }catch (SQLException ex){

                    }
                } else if (uusiArvo.toString() == "Himos") {
                    try{
                        String query = "select mokkinimi from mokki where toimintaalue_id = 4;";
                        PreparedStatement lause = connectDB.prepareStatement(query);
                        ResultSet tulokset = lause.executeQuery();
                        while(tulokset.next()){
                            listahimos.add(tulokset.getString("mokkinimi"));
                        }
                        cboxMokki.setItems(listahimos);
                        lause.close();
                        tulokset.close();


                    }catch (SQLException ex){

                    }
                } else if (uusiArvo.toString() == "Levi") {
                    try{
                        String query = "select mokkinimi from mokki where toimintaalue_id = 5;";
                        PreparedStatement lause = connectDB.prepareStatement(query);
                        ResultSet tulokset = lause.executeQuery();
                        while(tulokset.next()){
                            listalevi.add(tulokset.getString("mokkinimi"));
                        }
                        cboxMokki.setItems(listalevi);
                        lause.close();
                        tulokset.close();


                    }catch (SQLException ex){

                    }
                } else if (uusiArvo.toString() == "Koli") {
                    try{
                        String query = "select mokkinimi from mokki where toimintaalue_id = 6;";
                        PreparedStatement lause = connectDB.prepareStatement(query);
                        ResultSet tulokset = lause.executeQuery();
                        while(tulokset.next()){
                            listakoli.add(tulokset.getString("mokkinimi"));
                        }
                        cboxMokki.setItems(listakoli);
                        lause.close();
                        tulokset.close();


                    }catch (SQLException ex){

                    }
                } else if (uusiArvo.toString() == "Vuokatti") {
                    try{
                        String query = "select mokkinimi from mokki where toimintaalue_id = 7;";
                        PreparedStatement lause = connectDB.prepareStatement(query);
                        ResultSet tulokset = lause.executeQuery();
                        while(tulokset.next()){
                            listavuokatti.add(tulokset.getString("mokkinimi"));
                        }
                        cboxMokki.setItems(listavuokatti);
                        lause.close();
                        tulokset.close();


                    }catch (SQLException ex){

                    }
                } else if (uusiArvo.toString() == "Pallas") {
                    try{
                        String query = "select mokkinimi from mokki where toimintaalue_id = 8;";
                        PreparedStatement lause = connectDB.prepareStatement(query);
                        ResultSet tulokset = lause.executeQuery();
                        while(tulokset.next()){
                            listapallas.add(tulokset.getString("mokkinimi"));
                        }
                        cboxMokki.setItems(listapallas);
                        lause.close();
                        tulokset.close();


                    }catch (SQLException ex){

                    }
                }
                removeDuplicatesMokki();
            }
        });
    }

    // Laittaa Varausnäytön varoitustekstin näkymättömäksi
    public void Varoitus() {
        txtVarausVaroitus.setVisible(false);
    }

    //lista johon menee kaikki Varaus-oliot
    ObservableList<Varaus> tilausLista = FXCollections.observableArrayList();
    //lista johon menee kaikki laskutustiedot
    ObservableList<Lasku> LaskuLista = FXCollections.observableArrayList();

    // Lisää varauksen tiedot varausnäytön tauluun
    public void Btlisaa(){


        // näyttää virhetekstin jos käyttäjä unohtaa täyttää kaikki pakolliset kentät
        if (cboxToimintaalue.getSelectionModel().getSelectedItem() == null || cboxHenkilomaara.getSelectionModel().getSelectedItem() == null || cboxAsiakkaat.getValue().toString() == "" || cboxMokki.getSelectionModel().getSelectedItem() == null || dptulopaiva.getValue() == null || dplahtopaiva.getValue() == null || tfSposti.getCharacters().toString() == "") {
            txtVarausVaroitus.setVisible(true);
        } else {
            txtVarausVaroitus.setVisible(false);
            //tehdään muuttujat näytöllä olevista objekteista
            String toimintaalue = cboxToimintaalue.getSelectionModel().getSelectedItem().toString();
            String tulopaiva = dptulopaiva.getValue().toString();
            String lahtopaiva = dplahtopaiva.getValue().toString();
            Object hlomaara = cboxHenkilomaara.getSelectionModel().getSelectedItem();
            String asiakas = cboxAsiakkaat.getValue().toString();
            Object mokki = cboxMokki.getSelectionModel().getSelectedItem();
            Object palvelut = cboxPalvelut.getSelectionModel().getSelectedItem();
            String sposti = tfSposti.getCharacters().toString();

            tcToimintaalue.setCellValueFactory(new PropertyValueFactory<Varaus, String>("toimintaalue"));
            tcTulopaiva.setCellValueFactory(new PropertyValueFactory<Varaus, String>("tulopaiva"));
            tcLahtopaiva.setCellValueFactory(new PropertyValueFactory<Varaus, String>("lahtopaiva"));
            tcHenkilomaara.setCellValueFactory(new PropertyValueFactory<Varaus, String>("henkilomaara"));
            tcAsiakas.setCellValueFactory(new PropertyValueFactory<Varaus, String>("asiakas"));
            tcPalvelut.setCellValueFactory(new PropertyValueFactory<Varaus, String>("palvelut"));
            tcMokki.setCellValueFactory(new PropertyValueFactory<Varaus, String>("mokki"));
            tcSposti.setCellValueFactory(new PropertyValueFactory<Varaus, String>("sposti"));

            tcToimintaalue_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("toimintaalue"));
            tcTulopaiva_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("tulopaiva"));
            tcLahtopaiva_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("lahtopaiva"));
            tcHlomaara_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, Integer>("henkilomaara"));
            tcAsiakas_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("asiakas"));
            tcPalvelut_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("palvelut"));
            tcMokki_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("mokki"));
            tcSposti_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("sposti"));




            // Lisätään tilausListan Itemit tableViewiin
            tvTableView.setItems(tilausLista);
            //Lisätään Laskulistan itemit Laskutusnäytön tableviewiin
            tvLasku.setItems(LaskuLista);

            // tehdään muuttujien perusteella Varaus-olio, joka lisätään tilausListaan
            tilausLista.add(new Varaus(toimintaalue, tulopaiva, lahtopaiva, hlomaara, asiakas, palvelut, mokki, sposti));
            // tehdään muuttujien perusteella Lasku-olio, jotta saadaan varaustiedot myös laskutusnäyttöön
            LaskuLista.add(new Lasku(toimintaalue, tulopaiva, lahtopaiva, hlomaara, asiakas, palvelut, mokki, sposti));
            LisaaVaraus();
            LisaaLasku();

        }

    }

    /**
     * MÖKKIENHALLINTANÄKYMÄ
     */

    /**Lisätään mökille toiminta-alue ID

     public int HaeToimintaAlueid() {
     int toimintaAlueId;
     String toimintaAlueNimi = cboxToimintaalue2.getValue().toString();

     if (toimintaAlueNimi.equals("TAHKO"))
     toimintaAlueId = 1;
     else if (toimintaAlueNimi.equals("RUKA"))
     toimintaAlueId = 2;
     else if (toimintaAlueNimi.equals("YLLÄS"))
     toimintaAlueId = 3;
     else if (toimintaAlueNimi.equals("HIMOS"))
     toimintaAlueId = 4;
     else if (toimintaAlueNimi.equals("LEVI"))
     toimintaAlueId = 5;
     else if (toimintaAlueNimi.equals("KOLI"))
     toimintaAlueId = 6;
     else if (toimintaAlueNimi.equals("VUOKATTI"))
     toimintaAlueId = 7;
     else if (toimintaAlueNimi.equals("PALLAS"))
     toimintaAlueId = 8;
     else
     toimintaAlueId = 0;

     return toimintaAlueId;
     }
     */
    //Lisätään lista, johon lisätään kaikki mökki-oliot
    ObservableList<Mokki> mokit = FXCollections.observableArrayList();

    // vaaditaan yhteyden muodostamiseen
    public void PaivitaMokki() {

        try {

            SQLYhteys connectNow = new SQLYhteys();
            Connection connectDB = connectNow.getYhteys();

            String query1 = "UPDATE mokki SET toimintaalue_id=?, postinro=?,mokkinimi=?,katuosoite=?, kuvaus =?,henkilomaara=?, varustelu=?, hinta=?, alv=? WHERE mokki_id = ?";

            PreparedStatement pst1 = connectDB.prepareStatement(query1);
        } catch (Exception e) {
        }
        return;
    }

    // Lisää mökkien tiedot mökkinäytön tauluun
    public void LisaaMokki() {



        //

        //Lisätään tiedot SQL tietokantaan
        try {

            //Sql yhteyden määrittäminen
            SQLYhteys connectNow = new SQLYhteys();
            Connection connectDB = connectNow.getYhteys();

            //Sql lause asiakkaiden luomiselle
            String query1 = "insert into mokki (mokki_id, toimintaalue_id, postinro,mokkinimi,katuosoite, kuvaus ,henkilomaara, varustelu, hinta, alv)values(?,?,?,?,?,?,?,?,?,?)";

            //Preparedstatement määrittää sql lauseen
            PreparedStatement sqlmokki = connectDB.prepareStatement(query1);

            //Noudetaan tiedot textfieldistä
            sqlmokki.setInt(1,Integer.parseInt(txtfMokkienhallintaMokkiID.getText()));
            sqlmokki.setInt(2,Integer.parseInt(txtfMokkienhallintaTAid.getText()));
            sqlmokki.setString(3,txtfMokkienhallintaPostinumero.getText());
            sqlmokki.setString(4,txtfMokkienhallintaMokkinimi.getText());
            sqlmokki.setString(5,txtfMokkienhallintaKatuosoite.getText());
            sqlmokki.setString(6,txtfMokkienhallintaKuvaus.getText());
            sqlmokki.setInt(7,Integer.parseInt(txtfMokkienhallintaHlomaara.getText()));
            sqlmokki.setString(8,txtfMokkienhallintaVarustelu.getText());
            sqlmokki.setDouble(9,Double.parseDouble(txtfMokkienhallintaHinta.getText()));
            sqlmokki.setDouble(10,Double.parseDouble(txtfMokkienhallintaAlv.getText()));

            //Suoritetaan SQL komennot
            sqlmokki.executeUpdate();

            //Kutsutaan metodia, jolla päivitetään tiedot automaattisesti
            PaivitaMokki();

        } catch(Exception e) {
            System.err.println("vahinko");
            System.err.println(e.getMessage());

        }

        Mokki mokki3 = new Mokki();
        if (mokki3.listaaMokit() != null) {
            lataaMokkiTaulu();
        }
    }

    public void lataaMokkiTaulu() {
        //toimii
        tbvMokkienhallintaMokit.getItems().clear();
        Mokki mokkienhallinta = new Mokki();
        List<Mokki>  mokitlista = mokkienhallinta.listaaMokit();
        ObservableList<Mokki> taulunmokit = FXCollections.observableArrayList(mokitlista);

        CmokkienhallintaNimi.setCellValueFactory(new PropertyValueFactory<Mokki, String>("mokkinimi"));
        CmokkienhallintaOsoite.setCellValueFactory(new PropertyValueFactory<Mokki, String>("katuosoite"));
        CmokkienhallintaKuvaus.setCellValueFactory(new PropertyValueFactory<Mokki, String>("kuvaus"));
        CmokkienhallintaHlomaara.setCellValueFactory(new PropertyValueFactory<Mokki, String>("henkilomaara"));
        CmokkienhallintaVarustelu.setCellValueFactory(new PropertyValueFactory<Mokki, String>("varustelu"));
        CmokkienhallintaPostinro.setCellValueFactory(new PropertyValueFactory<Mokki, String>("postinro"));
        CmokkienhallintaHinta.setCellValueFactory(new PropertyValueFactory<Mokki, Double>("hinta"));
        CmokkienhallintaAlv.setCellValueFactory(new PropertyValueFactory<Mokki, Double>("alv"));
        CmokkienhallintaID.setCellValueFactory(new PropertyValueFactory<Mokki, Integer>("mokkiID"));
        tbvMokkienhallintaMokit.setItems(taulunmokit);
    }
    public void BtMokkiPoista() throws SQLException {

        Mokki poistamokki = new Mokki();
        Mokki valittumokki = (Mokki) tbvMokkienhallintaMokit.getSelectionModel().getSelectedItem();
        Mokki mokki3 = new Mokki();
        mokki3.setMokkiID(valittumokki.getMokkiID());
        poistamokki.PoistaMokki(mokki3.getMokkiID());
        tyhjennaTekstiKentat_mokki();
        lataaMokkiTaulu();
    }
    public void tyhjennaTekstiKentat_mokki() {

        //toimii
        txtfMokkienhallintaMokkiID.setText("");
        txtfMokkienhallintaTAid.setText("");
        txtfMokkienhallintaPostinumero.setText("");
        txtfMokkienhallintaMokkinimi.setText("");
        txtfMokkienhallintaKatuosoite.setText("");
        txtfMokkienhallintaKuvaus.setText("");
        txtfMokkienhallintaHlomaara.setText("");
        txtfMokkienhallintaVarustelu.setText("");
        txtfMokkienhallintaHinta.setText("");
        txtfMokkienhallintaAlv.setText("");
    }

    // ASIAKASHALLINTA SQL
    // Asiakastaulu

    // Tämä lähinnä testin vuoksi -> vaaditaan kuitenkin yhteyden muodostamiseen
    public void PaivitaAsiakas() {

        try {

            SQLYhteys connectNow = new SQLYhteys();
            Connection connectDB = connectNow.getYhteys();

            String query = "UPDATE asiakas SET postinro = ?, etunimi= ?, sukunimi = ?, lahiosoite = ?, email = ?, puhelinnro = ? WHERE asiakas_id = ?";

            PreparedStatement pst = connectDB.prepareStatement(query);
        } catch (Exception e) {
        }
        return;
    }

    ObservableList<Asiakas> asiakasobslist = FXCollections.observableArrayList();

    //Asiakkaiden lisääminen sql asiakas tauluun
    public void BtTallennaAsiakas() {

        try {

            //Sql yhteyden määrittäminen
            SQLYhteys connectNow = new SQLYhteys();
            Connection connectDB = connectNow.getYhteys();

            //Sql lause asiakkaiden luomiselle
            String query = "insert into asiakas (postinro,etunimi,sukunimi,lahiosoite,email,puhelinnro)values(?,?,?,?,?,?)";

            //Preparedstatement määrittää sql lauseen
            PreparedStatement sqlasiakas = connectDB.prepareStatement(query);

            //Noudetaan tiedot textfieldistä
            sqlasiakas.setString(1,tfPostinro.getText());
            sqlasiakas.setString(2,tfEtunimi.getText());
            sqlasiakas.setString(3,tfSukunimi.getText());
            sqlasiakas.setString(4,tfLahiosoite.getText());
            sqlasiakas.setString(5,tfEmail.getText());
            sqlasiakas.setString(6,tfPuhelinnro.getText());

            //Suoritetaan SQL komennot
            sqlasiakas.executeUpdate();

            //Kutsutaan metodia, jolla päivitetään tiedot automaattisesti
            PaivitaAsiakas();

            //Päivitetään tableview
            Asiakas asiakas = new Asiakas();
            if (asiakas.listaaAsiakkaat() != null) {
                lataaAsiakasTaulu();
            }

            //Päivitetään Asiakas ID combobox
            String query1 = "select asiakas_id from asiakas";
            PreparedStatement lause = connectDB.prepareStatement(query1);
            ResultSet tulokset = lause.executeQuery();
            while(tulokset.next()){
                options.add(tulokset.getString("asiakas_id"));

            }
            cboxAsiakkaat.setItems(options);
            lause.close();
            tulokset.close();
            removeDuplicates();

        } catch(Exception e) {
        }
    }

    //Poistaa asiakas_id duplikaatit
    public void removeDuplicates() {

        int size = options.size();
        int duplicates = 0;

        for (int i = 0; i < size - 1; i++) {

            for (int j = i + 1; j < size; j++) {

                if (!options.get(j).equals(options.get(i)))
                    continue;
                duplicates++;
                options.remove(j);

                j--;

                size--;
            }
        }
    }
    //Poistaa asiakas_id duplikaatit
    public void removeDuplicatesMokki() {

        int tahko = listamokkicbox.size();
        int ruka = listaruka.size();
        int yllas = listayllas.size();
        int himos = listahimos.size();
        int levi = listalevi.size();
        int koli = listakoli.size();
        int vuokatti = listavuokatti.size();
        int pallas = listapallas.size();

        int duplicates = 0;

        for (int i = 0; i < tahko - 1; i++) {

            for (int j = i + 1; j < tahko; j++) {

                if (!listamokkicbox.get(j).equals(listamokkicbox.get(i)))
                    continue;
                duplicates++;
                listamokkicbox.remove(j);

                j--;

                tahko--;
            }
        }
        for (int i = 0; i < ruka - 1; i++) {

            for (int j = i + 1; j < ruka; j++) {

                if (!listaruka.get(j).equals(listaruka.get(i)))
                    continue;
                duplicates++;
                listaruka.remove(j);

                j--;

                ruka--;
            }
        }
        for (int i = 0; i < yllas - 1; i++) {

            for (int j = i + 1; j < yllas; j++) {

                if (!listayllas.get(j).equals(listayllas.get(i)))
                    continue;
                duplicates++;
                listayllas.remove(j);

                j--;

                yllas--;
            }
        }
        for (int i = 0; i < himos - 1; i++) {

            for (int j = i + 1; j < himos; j++) {

                if (!listahimos.get(j).equals(listahimos.get(i)))
                    continue;
                duplicates++;
                listahimos.remove(j);

                j--;

                himos--;
            }
        }
        for (int i = 0; i < levi - 1; i++) {

            for (int j = i + 1; j < levi; j++) {

                if (!listalevi.get(j).equals(listalevi.get(i)))
                    continue;
                duplicates++;
                listalevi.remove(j);

                j--;

                levi--;
            }
        }
        for (int i = 0; i < koli - 1; i++) {

            for (int j = i + 1; j < koli; j++) {

                if (!listakoli.get(j).equals(listakoli.get(i)))
                    continue;
                duplicates++;
                listakoli.remove(j);

                j--;

                koli--;
            }
        }
        for (int i = 0; i < vuokatti - 1; i++) {

            for (int j = i + 1; j < vuokatti; j++) {

                if (!listavuokatti.get(j).equals(listavuokatti.get(i)))
                    continue;
                duplicates++;
                listavuokatti.remove(j);

                j--;

                vuokatti--;
            }
        }
        for (int i = 0; i < pallas - 1; i++) {

            for (int j = i + 1; j < pallas; j++) {

                if (!listapallas.get(j).equals(listapallas.get(i)))
                    continue;
                duplicates++;
                listapallas.remove(j);

                j--;

                pallas--;
            }
        }
    }


    public void BtAsiakasPoista() throws SQLException {

        Asiakas poistaasiakas = new Asiakas();
        Asiakas valittuasiakas = (Asiakas) tbvAsiakas.getSelectionModel().getSelectedItem();
        Asiakas asiakas = new Asiakas();
        asiakas.setAsiakas_id(valittuasiakas.getAsiakas_id());
        poistaasiakas.PoistaAsiakas(asiakas.getAsiakas_id());
        tyhjennaTekstiKentat_asiakas();
        lataaAsiakasTaulu();
    }

  /*  public void BtMuokkaaAsiakas() throws SQLException{
        Asiakas asiakashallinta = new Asiakas();
        Asiakas asiakas = new Asiakas();
        Asiakas valittuasiakas = (Asiakas) tbvAsiakas.getSelectionModel().getSelectedItem();
        asiakas.setAsiakas_id(valittuasiakas.getAsiakas_id());
        Asiakas asiakas1 = asiakas.MuokkaaAsiakas(tfEtunimi.getText());
        asiakas1.setEtunimi(tfEtunimi.getText());
        asiakas1.setSukunimi(tfSukunimi.getText());
        asiakas1.setLahiosoite(tfLahiosoite.getText());
        asiakas1.setEmail(tfEmail.getText());
        asiakas1.setPostinro(tfPostinro.getText());
        asiakas1.setPuhelinnro(tfPuhelinnro.getText());


        asiakashallinta.PaivitaAsiakas(asiakas1);
        lataaAsiakasTaulu();
    }*/

    public void tyhjennaTekstiKentat_asiakas() {

        //toimii
        tfEtunimi.setText("");
        tfSukunimi.setText("");
        tfPuhelinnro.setText("");
        tfEmail.setText("");
        tfLahiosoite.setText("");
        tfPostinro.setText("");
    }

    public ComboBox cboxAsiakkaat;

  /*  public void VarausAsiakas(){

        cboxAsiakkaat.getItems().clear();
        Asiakas asiakas = new Asiakas();
        List<Asiakas>asiakasList = asiakas.listaaCombobox();
        ObservableList<Asiakas> comboboxasiakkaat = FXCollections.observableArrayList(asiakasList);
       // cboxAsiakkaat.setValue(new PropertyValueFactory<Asiakas, Integer>("asiakas_id"));
        cboxAsiakkaat.setItems(comboboxasiakkaat);

    }*/



    public void lataaAsiakasTaulu() {
        //toimii
        tbvAsiakas.getItems().clear();
        Asiakas asiakashallinta = new Asiakas();
        List<Asiakas> asiakaslista = asiakashallinta.listaaAsiakkaat();
        ObservableList<Asiakas> taulunasiakkaat = FXCollections.observableArrayList(asiakaslista);

        tbcAsiakas_id.setCellValueFactory(
                new PropertyValueFactory<Asiakas, Integer>("asiakas_id"));
        tbcEtunimi.setCellValueFactory(
                new PropertyValueFactory<Asiakas, String>("etunimi"));
        tbcSukunimi.setCellValueFactory(
                new PropertyValueFactory<Asiakas, String>("sukunimi"));
        tbcPuhelinnro.setCellValueFactory(
                new PropertyValueFactory<Asiakas, String>("puhelinnro"));
        tbcEmail.setCellValueFactory(
                new PropertyValueFactory<Asiakas, String>("email"));
        tbcLahiosoite.setCellValueFactory(
                new PropertyValueFactory<Asiakas, String>("lahiosoite"));
        tbcPostinro.setCellValueFactory(
                new PropertyValueFactory<Asiakas, String>("postinro"));
        tbvAsiakas.setItems(taulunasiakkaat);
    }


    /**
     * Laskunhallintanäkymä
     */

    //LASKUJEN HALLINTA
    public TextArea txtAreaLaskutiedot_Lasku;
    public Button btLahetaLasku;

    //Laskujenhallinta table
    public TextField tfSposti;
    public TableView <Lasku> tvLasku;
    public TableColumn<Lasku, String> tcToimintaalue_Lasku;
    public TableColumn<Lasku, String> tcTulopaiva_Lasku;
    public TableColumn<Lasku, String> tcLahtopaiva_Lasku;
    public TableColumn<Lasku, Integer> tcHlomaara_Lasku;
    public TableColumn<Lasku, String> tcAsiakas_Lasku;
    public TableColumn<Lasku, String> tcPalvelut_Lasku;
    public TableColumn<Lasku, String> tcMokki_Lasku;
    public TableColumn<Lasku, String> tcSposti_Lasku;
    public TableColumn<Lasku, Integer> tcLaskuID;

    public void naytaLaskuTiedot() {


        tvLasku.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {

            if (tvLasku.getSelectionModel().getSelectedItem() != null) {
                txtAreaLaskutiedot_Lasku.setText("Toiminta-alue: " + tvLasku.getSelectionModel().getSelectedItem().toimintaalue + "\nTulopäivä: " + tvLasku.getSelectionModel().getSelectedItem().tulopaiva + "\nLähtöpäivä: " + tvLasku.getSelectionModel().getSelectedItem().lahtopaiva + "\nHenkilömäärä: " + tvLasku.getSelectionModel().getSelectedItem().henkilomaara + "\nAsiakkaan nimi: " + tvLasku.getSelectionModel().getSelectedItem().asiakas + "\nPalvelut: " + tvLasku.getSelectionModel().getSelectedItem().palvelut + "\nMökki: " + tvLasku.getSelectionModel().getSelectedItem().mokki + "\nAsiakkaan sähköpostiosoite: " + tvLasku.getSelectionModel().getSelectedItem().sposti);
            } else {
                txtAreaLaskutiedot_Lasku.setText("Toiminta-alue:\nTulopäivä:\nLähtöpäivä:\nHenkilömäärä:\nAsiakkaan nimi:\nPalvelut:\nMökki:\nAsiakkaan sähköpostiosoite:");
            }
        });
    }

    public void lahetaEmail(String recepient) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        String msg = ("Hei, Tässä lasku varaamastasi mökistä\nToiminta-alue: "+tvLasku.getSelectionModel().getSelectedItem().toimintaalue+"\nTulopäivä: "+tvLasku.getSelectionModel().getSelectedItem().tulopaiva+"\nLähtöpäivä: "+tvLasku.getSelectionModel().getSelectedItem().lahtopaiva+"\nHenkilömäärä: "+tvLasku.getSelectionModel().getSelectedItem().henkilomaara+"\nAsiakkaan nimi: "+tvLasku.getSelectionModel().getSelectedItem().asiakas+"\nPalvelut: "+tvLasku.getSelectionModel().getSelectedItem().palvelut+"\nMökki: "+tvLasku.getSelectionModel().getSelectedItem().mokki+"\nSähköpostiosoite: "+tvLasku.getSelectionModel().getSelectedItem().sposti
                +"\n\nLasku maksetaan tilille FI20945830579348\nHinta: "+Lasku.laskeHinta(tvLasku.getSelectionModel().getSelectedItem().lasku_id));

        String myAccountEmail = "mvjarjestelma@gmail.com";
        String password = "Salasana123";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, recepient, msg);
        Transport.send(message);
        System.out.println("Email lähetettiin");
    }
    public static Message prepareMessage(Session session, String myAccountEmail, String recepient, String msg) throws NoClassDefFoundError {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Lasku varaamastasi mökistä");
            message.setText(msg);
            return message;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public void btLahetaLasku(ActionEvent actionEvent) throws Exception {
        System.out.println("Toiminta-alue: " + tvLasku.getSelectionModel().getSelectedItem().toimintaalue);
        System.out.println("Tulopäivä: " + tvLasku.getSelectionModel().getSelectedItem().tulopaiva);
        System.out.println("Lähtöpäivä: " + tvLasku.getSelectionModel().getSelectedItem().lahtopaiva);
        System.out.println("Henkilömäärä: " + tvLasku.getSelectionModel().getSelectedItem().henkilomaara);
        System.out.println("Asiakas: " + tvLasku.getSelectionModel().getSelectedItem().asiakas);
        System.out.println("Palvelut: " + tvLasku.getSelectionModel().getSelectedItem().palvelut);
        System.out.println("Mökki: " + tvLasku.getSelectionModel().getSelectedItem().mokki);
        System.out.println("Sähköpostiosoite: " + tvLasku.getSelectionModel().getSelectedItem().sposti);
        System.out.println(tvLasku.getSelectionModel().getSelectedItem().lasku_id);
        Lasku.laskeHinta(tvLasku.getSelectionModel().getSelectedItem().lasku_id);
        lahetaEmail(tvLasku.getSelectionModel().getSelectedItem().sposti);

    }
    public void PoistaVaraus(ActionEvent actionEvent) {

    }

    public void Poistamokki(ActionEvent actionEvent) {
    }
}