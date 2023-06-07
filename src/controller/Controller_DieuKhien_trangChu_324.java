
package controller;
import dao.SinhVienDao;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.SinhVien_trangChu_324;

public class Controller_DieuKhien_trangChu_324 {
    SinhVienDao dao;
    private String a ;
    private String hoTen;
    private JTable tbl = new JTable();
    DefaultListModel model = new DefaultListModel();
    JList list = new JList();

    DefaultTableModel defaultTableModel = new DefaultTableModel();
    public Controller_DieuKhien_trangChu_324() {
    }
    
    public Controller_DieuKhien_trangChu_324(String a,JTable tbls) {
        this.a = a;
        this.tbl = tbl;
    }
    public void tiemKiemTheoThongTin(String tenTT, String theLoai ,JTable tbl,DefaultTableModel defaultTableModel){
        this.tbl = tbl;
        dao = new SinhVienDao();
        setListSinhVien(dao.getThongTinTheoDieuKien_324(theLoai,tenTT),defaultTableModel); 
    }
    
    public int getKiemTraTen(String theLoai, String doiTuong){
        dao = new SinhVienDao();
        if(dao.getTen(theLoai,doiTuong)==null)
            return 0;
        else
            return 1;
    }
    

    public void quanLy_jList_queQuan(JList list){
        this.list = list;
        dao = new SinhVienDao();
        List<SinhVien_trangChu_324> sv = dao.getThongTinTheoQueQuan_324();
        for(SinhVien_trangChu_324 svn : sv ){
              model.addElement(svn.getQueQuan_324());
        }
        list.setModel(model);
    }
    
    
    public void SetTable(JTable tbl,DefaultTableModel defaultTableModel){
        this.tbl = tbl;
        dao = new SinhVienDao();
        setListSinhVien(dao.getTatCaThongTinSinhVien_324(),defaultTableModel);   
    }
    
    private void setListSinhVien(List<SinhVien_trangChu_324> listSV,DefaultTableModel defaultTableModel){
        this.defaultTableModel = defaultTableModel;
        tbl.setModel(defaultTableModel);
        for(SinhVien_trangChu_324 sn1 : listSV){
            defaultTableModel.addRow(new Object[]{sn1.getMaPhong_324(),sn1.getMsv_324(), sn1.getTen_324(), sn1.getCmnd_324(), sn1.isGioTinh_324(), sn1.getQueQuan_324()});
        }
    }
    
    
}

