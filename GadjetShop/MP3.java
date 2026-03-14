public class MP3 extends Gadget
{
    private int memory;

    public MP3(String model,double price,int weight,String size,int memory)
    {
        super(model,price,weight,size);
        this.memory = memory;
    }

    public int getMemory(){ return memory; }

    public String downloadMusic(int size)
    {
        if(size <= memory)
        {
            memory -= size;
            return "Music downloaded\nRemaining memory: " + memory;
        }
        else
        {
            return "Not enough memory";
        }
    }

    public String display()
    {
        return super.display() + "\nMemory: " + memory;
    }
}