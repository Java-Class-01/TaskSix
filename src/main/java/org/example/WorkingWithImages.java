package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class WorkingWithImages {
    JFrame FruitsFrame;
    JScrollPane scrollPane;
    JPanel cardsPanel,FruitCardPanel;
    public WorkingWithImages(){
        this.prepareMainFruitsFrame();
    }
    public JFrame prepareMainFruitsFrame(){
        FruitsFrame=new JFrame("Fruits Catalogue");
        FruitsFrame.setSize(700,500);
        FruitsFrame.add(this.prepareScrollPane());

        FruitsFrame.setVisible(true);
        return FruitsFrame;
    }
//creating the scrollpane to allow scrolling
public JScrollPane prepareScrollPane(){
    scrollPane=new JScrollPane(CardsPanel());
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.getVerticalScrollBar().setUnitIncrement(16);
    return scrollPane;
}
    public JPanel CardsPanel(){
        cardsPanel=new JPanel();
        cardsPanel.setLayout(new GridLayout(2,2,10,10));
        String[][] fruits={
                {"apple.jpg","APPLE", "APPLE", "Crisp, sweet and perfect for a healthy snack."},
                {"banana.jpg","BANANA","Rich in potassium, great for energy."},
                {"grapes.jpg","GRAPES", "Juicy and perfect for making wine or snacks."},
                {"mango.jpg","MANGO", "Tropical fruit known as the king of fruits."},
                {"pineapple.jpg","PINEAPPLE", "Tangy, tropical and full of vitamins."},
                {"orange.jpg","ORANGE", "Rich in vitamin C and refreshing taste."},
                {"watermelon.jpg","WATERMMELON", "Sweet, hydrating fruit perfect for summer."},
                {"jackfruit.jpg","JACKFRUIT", "Large tropical fruit with a meaty texture."},
                {"pear.jpg","PEAR", "Soft, juicy fruit with subtle sweetness."},
                {"strawberry.jpg","STRAWBERRY", "Bright red, sweet fruit used in desserts."}
        };
        for(String[] fruit:fruits){cardsPanel.add(prepareFruitCardPanel(fruit[0],fruit[1]));}
        return cardsPanel;
    }
    public JPanel prepareFruitCardPanel(String imageName,String fruitName){
        FruitCardPanel=new JPanel();
        FruitCardPanel.setLayout(new BoxLayout(FruitCardPanel,BoxLayout.Y_AXIS));
        FruitCardPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
        FruitCardPanel.setBackground(Color.white);

        JLabel nameLabel = new JLabel(fruitName);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel imageLabel = new JLabel(loadImageIcon(imageName,250,250));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        return FruitCardPanel;
    }
    public ImageIcon loadImageIcon(String imageName,int width,int height){
        String path = "images/" + imageName;
        ImageIcon mainicon=new ImageIcon(path);
        Image mainimage=mainicon.getImage();
        Image scaledImage=mainimage.getScaledInstance(width,height,Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);

    }

    //awab add the descriptions and the hover effects and any information you need to include
    //dont change the size of the main frame the scrolls wont be visible



}
