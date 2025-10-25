package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class WorkingWithImages {
    JFrame FruitsFrame;
    JScrollPane scrollPane;
    JPanel cardsPanel,FruitCardPanel,JPanelButtons,JPanelFruitCard;
    JLabel JLabelName,JLabelImage;
    JTextArea JTextAreaDescription;
    JButton JButtonViewMore,JButtonFavorite;
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
                {"apple.jpg","APPLE", "Crisp, sweet and perfect for a healthy snack."},
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
        FruitCardPanel.add(Box.createVerticalStrut(10));
        FruitCardPanel.add(this.prepareJLabelImage(imageName));
        FruitCardPanel.add(Box.createVerticalStrut(5));
        FruitCardPanel.add(this.prepareJLabelName(fruitName));
        FruitCardPanel.add(Box.createVerticalStrut(5));
        FruitCardPanel.add(this.prepareJTextAreaDescription(description));
        FruitCardPanel.add(Box.createVerticalStrut(10));
        FruitCardPanel.add(this.prepareJPanelButtons(fruitName, description, imageName));
        addHoverEffect(FruitCardPanel);

        return FruitCardPanel;
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
    // === Buttons Panel ===
    public JPanel prepareJPanelButtons(String fruitName, String description, String imageName) {
        JPanelButtons = new JPanel(new FlowLayout());
        JPanelButtons.setBackground(Color.WHITE);
        JPanelButtons.add(this.prepareJButtonViewMore(fruitName, description, imageName));
        JPanelButtons.add(this.prepareJButtonFavorite(fruitName));
        return JPanelButtons;
    }
    // === View More Button ===
    public JButton prepareJButtonViewMore(String fruitName, String description, String imageName) {
        JButtonViewMore = new JButton("View More");
        JButtonViewMore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(FruitsFrame,
                        fruitName + "\n\n" + description + "\n\nMore details coming soon!",
                        fruitName + " Details",
                        JOptionPane.INFORMATION_MESSAGE,
                        loadImageIcon(imageName, 100, 100));
            }
        });
        return JButtonViewMore;
    }

    // === Favorite Button ===
    public JButton prepareJButtonFavorite(String fruitName) {
        JButtonFavorite = new JButton("Add to Favorites");
        JButtonFavorite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(FruitsFrame,
                        fruitName + " added to favorites! ❤️",
                        "Favorites",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        return JButtonFavorite;
    }
    // === Hover Effect Helper ===
    private void addHoverEffect(JPanel panel) {
        MouseAdapter hover = new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                panel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
                panel.setBackground(new Color(255, 250, 240)); // light orange tint
                panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                panel.setBackground(Color.WHITE);
                panel.setCursor(Cursor.getDefaultCursor());
            }
        };

        // Add to the panel itself and all its children
        panel.addMouseListener(hover);
        for (Component c : panel.getComponents()) {
            c.addMouseListener(hover);
        }
    }



}
