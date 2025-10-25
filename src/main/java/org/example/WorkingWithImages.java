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
        cardsPanel.setLayout(new GridLayout(2,2));
        String[][] fruits={
                {"apple.jpg","APPLE"},
                {"banana.jpg","BANANA"},
                {"grapes.jpg","GRAPES",},
                {"mango.jpg","MANGO"},
                {"pineapple.jpg","PINEAPPLE"},
                {"orange.jpg","ORANGE"},
                {"watermelon.jpg","WATERMMELON"},
                {"jackfruit.jpg","JACKFRUIT"},
                {"pear.jpg","PEAR"},
                {"strawberry.jpg","STRAWBERRY"}
        };
        for(String[] fruit:fruits){cardsPanel.add(prepareFruitCardPanel(fruit[0],fruit[1]));}
        return cardsPanel;
    }



}
