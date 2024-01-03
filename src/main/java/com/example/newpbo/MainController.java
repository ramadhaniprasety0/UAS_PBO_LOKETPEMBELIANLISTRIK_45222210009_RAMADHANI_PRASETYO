package com.example.newpbo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert;

public class MainController {

    @FXML
    private TextField jumlahField;


    @FXML
    private Label kWhLabel;

    @FXML
    private Label NamaPelanggan;

    @FXML
    private Label saldoLabel;

    @FXML
    private TextArea transaksiTextArea;

    @FXML
    private TextField nomorTextField;

    @FXML
    private TextField noTlpnTextField;

    @FXML
    private Label NoMeter;

    @FXML
    private TextField jmlPktDataField;

    @FXML
    private Button beliTokenButton;

    @FXML
    private Button beliPaketDataButton;

    private Pengguna pengguna;

    @FXML
    private void loginByNomerMeter(ActionEvent event) {
        String nomorMeter = nomorTextField.getText();
        Pengguna pengguna = DataPengguna.getPenggunaByNomerMeter(nomorMeter);
        if (pengguna != null) {
            tampilkanAlert("Nomer Meter Listrik Benar ! ","Pelanggan "+pengguna.nama +" NoMeter : ( "+pengguna.NomerMeter+ " )");
            this.pengguna = pengguna;
            NamaPelanggan.setText("Nama Pengguna : " + pengguna.nama);
            saldoLabel.setText("Saldo: " + pengguna.getSaldo());
            kWhLabel.setText("kWh : " + pengguna.jumlahkWh);
            NoMeter.setText("No Meter : " +pengguna.NomerMeter);
            transaksiTextArea.setText(pengguna.getInfo());


        } else {
            tampilkanPeringatan("Nomer Meter Listrik Salah ! ","Mohon Untuk Mengecek Kembali No Meter Listrik Anda");
            NamaPelanggan.setText("Nama Pengguna : -");
            saldoLabel.setText("Saldo: -");
            kWhLabel.setText("kWh : -");
            NoMeter.setText("No Meter : -" );
        }
    }

    public void setDataPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }


    @FXML
    private void beliToken(ActionEvent event) {
        String nomorMeter = nomorTextField.getText();
        Pengguna pengguna = DataPengguna.getPenggunaByNomerMeter(nomorMeter);
        if (pengguna != null){
        double jumlah = Double.parseDouble(jumlahField.getText());
        double biayaKwh = pengguna.jumlahkWh;
        TokenListrik tokenListrik = new TokenListrik(jumlah, 1500,biayaKwh);
        double total = tokenListrik.hitungTotal(pengguna);
        String token = tokenListrik.getNomorToken();
        tampilkanAlert("Pembelian Berhasil ! ","Pembelian Token Listrik Berhasil !");
        transaksiTextArea.appendText("Proses Pembelian Token Pulsa Untuk Pelanggan : " + pengguna.nama +"\n");
        transaksiTextArea.appendText("Pembelian Token Pulsa Listrik ( No Meter : " + nomorMeter + " ): Rp" + jumlah + "\n");
        transaksiTextArea.appendText("Pembelian Token Pulsa Listrik Berhasil ( Kode Token : "+ token +" ): " + total +"kWh \n");
        saldoLabel.setText("Saldo: " + pengguna.getSaldo());
        }else {
            tampilkanPeringatan("Nomer Meter Listrik Salah ! ","Mohon Untuk Mengisi No Meter Listrik Terlebih Dahulu !");
        }
    }

    @FXML
    private void beliPaketData(ActionEvent event) {
        String NoTlp = noTlpnTextField.getText();
        String Jumlah = jmlPktDataField.getText();

        // Validasi apakah nomor telepon telah diisi
        if (Jumlah.trim().isEmpty()) {
            tampilkanPeringatan("Nominal Dan Nomer Telepon Kosong!", "Mohon untuk mengisi nominal pembelian dan nomor telepon terlebih dahulu!");
            return;
        }

        String regexPattern = "^\\d{12}$";
        double jumlah = Double.parseDouble(jmlPktDataField.getText());
        if (NoTlp.matches(regexPattern)) {
            PaketData paketData = new PaketData(jumlah, NoTlp, 10500);
            double total = paketData.hitungTotal(pengguna);
            tampilkanAlert("Pembelian Berhasil ! ","Pembelian Paket Data Internet Berhasil !");
            transaksiTextArea.appendText("Proses Pembelian Paket Data Internet Untuk Pelanggan : " + pengguna.nama + "\n");
            transaksiTextArea.appendText("Proses Pembelian Paket Data Internet ( NoHp : " + NoTlp + " ): Rp" + jumlah + "\n");
            transaksiTextArea.appendText("Pembelian Paket Data Internet Berhasil : " + total + "GB \n");
            saldoLabel.setText("Saldo: " + pengguna.getSaldo());
        } else {
            tampilkanPeringatan("Nomer Telepon Salah!", "Mohon untuk mengisi nomor telepon dengan 12 digit angka!");
        }
    }


    private void tampilkanPeringatan(String judul, String pesan) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(judul);
        alert.setHeaderText(null);
        alert.setContentText(pesan);
        alert.showAndWait();
    }

    private void tampilkanAlert(String judul, String pesan) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(judul);
        alert.setHeaderText(null);
        alert.setContentText(pesan);
        alert.showAndWait();
    }
}
