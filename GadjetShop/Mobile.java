public class Mobile extends Gadget
{
    private int credit;

    public Mobile(String model,double price,int weight,String size,int credit)
    {
        super(model,price,weight,size);
        this.credit = credit;
    }

    public int getCredit(){ return credit; }

    public String makeCall(String number,int duration)
    {
        if(duration <= credit)
        {
            credit -= duration;
            return "Calling " + number +
                   "\nDuration: " + duration +
                   "\nRemaining Credit: " + credit;
        }
        else
        {
            return "Not enough credit";
        }
    }

    public String display()
    {
        return super.display() + "\nCredit: " + credit;
    }
}