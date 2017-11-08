public class Auto{

    int hP;
    String name;
    String country;
    boolean isSport;
    boolean isAwd;

    Auto(int hP, String name, String country, boolean isAwd, boolean isSport)

    {
        this.hP = hP;
        this.name = name;
        this.country = country;

    }


    public int gethP() {
        return hP;
    }

    public void sethP(int hP) {
        this.hP = hP;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isSport() {
        return isSport;
    }

    public void setSport(boolean sport) {
        isSport = sport;
    }

    public boolean isAwd() {
        return isAwd;
    }

    public void setAwd(boolean awd) {
        isAwd = awd;
    }
}
