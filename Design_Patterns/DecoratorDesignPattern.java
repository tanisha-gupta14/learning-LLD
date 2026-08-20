package Design_Patterns;

interface Text{
    String render();
}

class PlainText implements Text{
    private String text;

    public PlainText(String text){
        this.text=text;
    }
    public String render(){
        return text;
    }
}

abstract class TextDecorator implements Text{
    protected Text text;
    public TextDecorator(Text text){
        this.text=text;
    }
}

class BoldText extends TextDecorator{
    public BoldText(Text text){
        super(text);
    }
    public String render(){
        return "<b>"+text.render()+"</b>";
    }
}
class ItalicText extends TextDecorator{
    public ItalicText(Text text){
        super(text);
    }
    public String render(){
        return "<i>"+text.render()+"</i>";
    }
}
class UnderlineText extends TextDecorator{
    public UnderlineText(Text text){
        super(text);
    }
    public String render(){
        return "<u>"+text.render()+"</u>";
    }
}
public class DecoratorDesignPattern {
    public static void main(String[] args){
        Text text=new PlainText("Hello World");
        Text boldText=new BoldText(text);
        Text italicText=new ItalicText(boldText);   
        Text underlineText=new UnderlineText(italicText);
        System.out.println(underlineText.render());
    }
    
}
