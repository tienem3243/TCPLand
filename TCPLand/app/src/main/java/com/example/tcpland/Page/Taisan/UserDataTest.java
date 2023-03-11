package com.example.tcpland.Page.Taisan;

public class UserDataTest {
    public UserDataTest(String id_user, String email, String password, String sdt, String tk_1_address, String tk_2_address, String tk_3_address, String tk_1_money, String tk_2_money, String tk_3_money, String hoten, String tructhuoc_id, int capbac, float luong, float hoahong, String quanly_id, String ngaythamgia, String status, String kind, String stk, String nganhang, String chu_tk) {
        this.id_user = id_user;
        this.email = email;
        this.password = password;
        this.sdt = sdt;
        this.tk_1_address = tk_1_address;
        this.tk_2_address = tk_2_address;
        this.tk_3_address = tk_3_address;
        this.tk_1_money = tk_1_money;
        this.tk_2_money = tk_2_money;
        this.tk_3_money = tk_3_money;
        this.hoten = hoten;
        this.tructhuoc_id = tructhuoc_id;
        this.capbac = capbac;
        this.luong = luong;
        this.hoahong = hoahong;
        this.quanly_id = quanly_id;
        this.ngaythamgia = ngaythamgia;
        this.status = status;
        this.kind = kind;
        this.stk = stk;
        this.nganhang = nganhang;
        this.chu_tk = chu_tk;
    }
    public UserDataTest(){}

    @Override
    public String toString() {
        String res=
//                "ID: " + id_user + '\n' +
//                "Email: " + email + '\n' +
//                "Password: " + password+ '\n' +
                "Sdt: " + sdt + '\n' +
                "Số dư ví : " + tk_1_money + '\n' +
                "Họ và tên: " + hoten + '\n' +
                "Trực thuộc: " + tructhuoc_id + '\n' +
                "Cấp bậc: " + capbac + '\n' +
                "Lương: " + luong + '\n' +
                "Hoa hồng: " + hoahong +"%" + '\n' +
                "Mã quản lý: " + quanly_id + '\n' +
                "Ngày tham gia: " + ngaythamgia + '\n' +
                "Trạng thái tài khoản: " + status + '\n' +
                "Số tài khoản ngân hàng: " + stk + '\n' +
                "Ngân hàng: " + nganhang + '\n' +
                "Tên chủ tài khoản: " + chu_tk + '\n';
        res=res.replace("[^a-zA-Z0-9]","").replace("null","");
        return  res;
    }

    String id_user="";
    String email="";
    String password="";
    String sdt="";
    String tk_1_address="";
    String tk_2_address="";
    String tk_3_address="";
    String tk_1_money="";
    String tk_2_money="";
    String tk_3_money="";
    String hoten="";
    String tructhuoc_id="";
    int capbac;
    float luong;
    float hoahong;
    String quanly_id="";
    String ngaythamgia="";
    String status;
    String kind;
    String stk;
    String nganhang="";
    String chu_tk;

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTk_1_address() {
        return tk_1_address;
    }

    public void setTk_1_address(String tk_1_address) {
        this.tk_1_address = tk_1_address;
    }

    public String getTk_2_address() {
        return tk_2_address;
    }

    public void setTk_2_address(String tk_2_address) {
        this.tk_2_address = tk_2_address;
    }

    public String getTk_3_address() {
        return tk_3_address;
    }

    public void setTk_3_address(String tk_3_address) {
        this.tk_3_address = tk_3_address;
    }

    public String getTk_1_money() {
        return tk_1_money;
    }

    public void setTk_1_money(String tk_1_money) {
        this.tk_1_money = tk_1_money;
    }

    public String getTk_2_money() {
        return tk_2_money;
    }

    public void setTk_2_money(String tk_2_money) {
        this.tk_2_money = tk_2_money;
    }

    public String getTk_3_money() {
        return tk_3_money;
    }

    public void setTk_3_money(String tk_3_money) {
        this.tk_3_money = tk_3_money;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getTructhuoc_id() {
        return tructhuoc_id;
    }

    public void setTructhuoc_id(String tructhuoc_id) {
        this.tructhuoc_id = tructhuoc_id;
    }

    public float getCapbac() {
        return capbac;
    }

    public void setCapbac(int capbac) {
        this.capbac = capbac;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public float getHoahong() {
        return hoahong;
    }

    public void setHoahong(float hoahong) {
        this.hoahong = hoahong;
    }

    public String getQuanly_id() {
        return quanly_id;
    }

    public void setQuanly_id(String quanly_id) {
        this.quanly_id = quanly_id;
    }

    public String getNgaythamgia() {
        return ngaythamgia;
    }

    public void setNgaythamgia(String ngaythamgia) {
        this.ngaythamgia = ngaythamgia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }

    public String getNganhang() {
        return nganhang;
    }

    public void setNganhang(String nganhang) {
        this.nganhang = nganhang;
    }

    public String getChu_tk() {
        return chu_tk;
    }

    public void setChu_tk(String chu_tk) {
        this.chu_tk = chu_tk;
    }
}
