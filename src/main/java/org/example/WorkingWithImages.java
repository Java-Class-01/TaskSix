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



}
