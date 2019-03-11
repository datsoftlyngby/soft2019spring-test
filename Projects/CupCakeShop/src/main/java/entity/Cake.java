package entity;

public class Cake
{
    private int id;
    private Top top;
    private Bottom bottom;
    private String name;
    
    public Cake()
    {
    }

    public Cake(int id, Top topping, Bottom bottom, String cakeName)
    {
        this.id = id;
        this.top = topping;
        this.bottom = bottom;
        this.name = cakeName;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String cakeName)
    {
        this.name = cakeName;
    }
    
    public Top getTop()
    {
        return top;
    }

    public void setTop(Top topping)
    {
        this.top = topping;
    }

    public Bottom getBottom()
    {
        return bottom;
    }

    public void setBottom(Bottom bottom)
    {
        this.bottom = bottom;
    }

    @Override
    public String toString()
    {
        return "Cake{" + "id=" + id + ", top=" + top + ", bottom=" + bottom + ", name=" + name + '}';
    }    
}