package org.example.prototype_pattern;

public abstract class Shape implements Cloneable {

    private Long id;
    protected String type;

    abstract void draw();

    public String getType(){ return this.type; }
    public Long getId() { return this.id; }

    public void setType(String type) { this.type = type; }
    public void setId(Long id) { this.id = id; }


    public Object clone(){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return clone;
    }
}
