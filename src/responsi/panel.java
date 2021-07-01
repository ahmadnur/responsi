/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;


/**
 *
 * @author WINDOWS 10
 */
public class panel extends JFrame {
        public String nama_aset, jumlah_aset, harga_aset, nilai_aset;
    int jmlData;
    String data[][] = new String[500][4];
   connector connector = new connector();    
JFrame window = new JFrame("JDBC");
   JTable tabel;
    DefaultTableModel tableModel; //otomatis dibuat kalo buat JTable
    JScrollPane scrollPane;
    Object namaKolom[] = {"Nama Aset","Jumlah","Harga","Nilai"}; //membuat kolom dgn array tipe object;

    JLabel lnama = new JLabel("Nama Aset");
        JTextField tfnama = new JTextField();
    JLabel ljumlah = new JLabel("Jumlah");
        JTextField tfjumlah = new JTextField();
    JLabel lharga= new JLabel("Harga");
        JTextField tfharga = new JTextField();

    JButton btnTambah = new JButton("Tambah");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnClear = new JButton("Clear");


public panel() {
        window.setLayout(null);
        window.setSize(800,400);
      //  window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

tabel = new JTable(data,namaKolom); //tabel merupakan variabel untuk tabelnya dengan isi tablemodel
        scrollPane = new JScrollPane(tabel);
        window.add(scrollPane);
        
        scrollPane.setBounds(20, 30, 500, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

       // setDefaultCloseOperation(EXIT_ON_CLOSE);

//ADD COMPONENT
        window.add(lnama);
        window.add(tfnama);
        window.add(tfharga);
        window.add(tfjumlah);
        window.add(lharga);
        window.add(ljumlah);
        window.add(btnTambah);
        window.add(btnUpdate);
        window.add(btnDelete);
        window.add(btnClear);



//LABEL
        lnama.setBounds(530, 30, 120, 20);
        ljumlah.setBounds(530,70 , 120, 20);
        lharga.setBounds(530,110,120,20);
//TEXTFIELD
        tfnama.setBounds(530, 50, 120, 20);
        tfharga.setBounds(530, 90, 120, 20);
        tfjumlah.setBounds(530, 130, 120, 20);

//BUTTON PANEL
        btnTambah.setBounds(550, 200, 90, 20);
        btnUpdate.setBounds(550,225,90,20);
        btnDelete.setBounds(550,250,90,20);
        btnClear.setBounds(550,275,90,20);
        
         btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                   try {
            String query = "INSERT INTO `aset`(`nama_aset`, `jumlah_aset`,`harga_aset`,`nilai_aset`) VALUES ('"+getNama()+"','"+getJumlah()+"','"+getHarga()+"','"+""+"')";
            
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);

            System.out.println("Insert Berhasil");
            JOptionPane.showMessageDialog(null,"Insert Berhasil !!");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
            }
        });
        

}
    public String Harga,Jumlah;
    public String getNama(){
        return tfnama.getText();
    }
    
    public String getHarga() {
        return tfharga.getText();
    }
    public String setHarga() {
        this.Harga=tfharga.getText();
        return Harga;
    }

    public String getJumlah() {
        return tfjumlah.getText();
    }
    public String setJumlah() {
        this.Jumlah=tfjumlah.getText();
        return Jumlah;
    }
  //  public int harga=Integer.parseInt(setHarga());
    //public int jumlah=Integer.parseInt(setJumlah());
    //int nilai = harga*jumlah;
}
