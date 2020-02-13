
package chhartrihalladmin;


public class Data {
    String RoomNo;
    int StudentId;
    double CGPA;
    int ExRoom;
    String Status;
    int AvailableRoom;
    
    Data(){
        
    }

    public Data(String RoomNo, int StudentId, double CGPA, int ExRoom, String Status, int AvailableRoom) {
        this.RoomNo = RoomNo;
        this.StudentId = StudentId;
        this.CGPA = CGPA;
        this.ExRoom = ExRoom;
        this.Status = Status;
        this.AvailableRoom = AvailableRoom;
    }

    public void setRoomNo(String RoomNo) {
        this.RoomNo = RoomNo;
    }

    public void setStudentId(int StudentId) {
        this.StudentId = StudentId;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public void setExRoom(int ExRoom) {
        this.ExRoom = ExRoom;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setAvailableRoom(int AvailableRoom) {
        this.AvailableRoom = AvailableRoom;
    }

    public String getRoomNo() {
        return RoomNo;
    }

    public int getStudentId() {
        return StudentId;
    }

    public double getCGPA() {
        return CGPA;
    }

    public int getExRoom() {
        return ExRoom;
    }

    public String getStatus() {
        return Status;
    }

    public int getAvailableRoom() {
        return AvailableRoom;
    }

//    String getText() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}

    