package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class WorkingWithImages {
    JFrame FruitsFrame;
    JScrollPane scrollPane;
    JPanel cardsPanel,FruitCardPanel,JPanelFruitCard;
    JLabel JLabelName,JLabelImage;
    JTextArea JTextAreaDescription;
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
        for(String[] fruit:fruits){cardsPanel.add(prepareFruitCardPanel(fruit[0],fruit[1],fruit[2]));}
        return cardsPanel;
    }
    public JPanel prepareFruitCardPanel(String imageName,String fruitName,String description) {
        FruitCardPanel = new JPanel();
        FruitCardPanel.setLayout(new BoxLayout(FruitCardPanel, BoxLayout.Y_AXIS));
        FruitCardPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        FruitCardPanel.setBackground(Color.white);
        // Add Components
        JPanelFruitCard.add(Box.createVerticalStrut(10));
        JPanelFruitCard.add(this.prepareJLabelImage(imageName));
        JPanelFruitCard.add(Box.createVerticalStrut(5));
        JPanelFruitCard.add(this.prepareJLabelName(fruitName));
        JPanelFruitCard.add(Box.createVerticalStrut(5));
        JPanelFruitCard.add(this.prepareJTextAreaDescription(description));
        JPanelFruitCard.add(Box.createVerticalStrut(10));
        JPanelFruitCard.add(this.prepareJPanelButtons(fruitName, description, imageName));
        // Hover Effect
        JPanelFruitCard.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                JPanelFruitCard.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
                JPanelFruitCard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                JPanelFruitCard.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                JPanelFruitCard.setCursor(Cursor.getDefaultCursor());
            }
        });

        return JPanelFruitCard;
    }
    public JLabel prepareJLabelName(String fruitName) {
        JLabelName = new JLabel(fruitName);
        JLabelName.setFont(new Font("Arial", Font.BOLD, 14));
        JLabelName.setAlignmentX(Component.CENTER_ALIGNMENT);
        return JLabelName;
    }
    public JLabel prepareJLabelImage(String imageName) {
        JLabelImage = new JLabel(loadImageIcon(imageName,250,250));
        JLabelImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        return JLabelImage;
    }


    public ImageIcon loadImageIcon(String imageName,int width,int height){
        String path = "images/" + imageName;
        ImageIcon mainicon=new ImageIcon(path);
        Image mainimage=mainicon.getImage();
        Image scaledImage=mainimage.getScaledInstance(width,height,Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);

    }
    public JTextArea prepareJTextAreaDescription(String description) {
        JTextAreaDescription = new JTextArea(description);
        JTextAreaDescription.setLineWrap(true);
        JTextAreaDescription.setWrapStyleWord(true);
        JTextAreaDescription.setEditable(false);
        JTextAreaDescription.setBackground(Color.WHITE);
        JTextAreaDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
        return JTextAreaDescription;
    }



}
