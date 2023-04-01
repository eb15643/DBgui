package project;

public class Employee {

    private String f_name;
    private String l_name;
    private int e_ssn;
    private int d_num;
    private int superssn;


    public Employee(String f_name, String l_name, int e_ssn, int d_num, int superssn) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.e_ssn = e_ssn;
        this.d_num = d_num;
        this.superssn = superssn;
    }


    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public int getE_ssn() {
        return e_ssn;
    }

    public int getD_num() {
        return d_num;
    }

    public int getSuperssn() {
        return superssn;
    }


}
