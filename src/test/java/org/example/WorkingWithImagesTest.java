package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assertions.*;

public class WorkingWithImagesTest {
    
    private WorkingWithImages workingWithImages;
    
    @BeforeEach
    void setUp() {
        // Skip GUI tests in headless environment (like CI/CD)
        assumeFalse(GraphicsEnvironment.isHeadless(), "Skipping GUI tests in headless environment");
        workingWithImages = new WorkingWithImages();
    }
    
    @Test
    void testPrepareMainFruitsFrame() {
        JFrame frame = workingWithImages.prepareMainFruitsFrame();
        assertNotNull(frame);
        assertEquals("Fruits Catalogue", frame.getTitle());
        assertTrue(frame.getSize().width > 0);
        assertTrue(frame.getSize().height > 0);
    }
    
    @Test
    void testPrepareScrollPane() {
        JScrollPane scrollPane = workingWithImages.prepareScrollPane();
        assertNotNull(scrollPane);
        assertEquals(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED, 
                    scrollPane.getHorizontalScrollBarPolicy());
        assertEquals(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                    scrollPane.getVerticalScrollBarPolicy());
    }
    
    @Test
    void testCardsPanel() {
        JPanel cardsPanel = workingWithImages.CardsPanel();
        assertNotNull(cardsPanel);
        assertTrue(cardsPanel.getComponentCount() > 0);
    }
    
    @Test
    void testPrepareFruitCardPanel() {
        JPanel fruitCard = workingWithImages.prepareFruitCardPanel(
            "apple.jpg", "APPLE", "Test description for apple"
        );
        assertNotNull(fruitCard);
        assertTrue(fruitCard.getComponentCount() > 0);
    }
    
    @Test
    void testPrepareJLabelName() {
        JLabel label = workingWithImages.prepareJLabelName("TEST FRUIT");
        assertNotNull(label);
        assertEquals("TEST FRUIT", label.getText());
    }
    
    @Test
    void testPrepareJLabelImage() {
        JLabel imageLabel = workingWithImages.prepareJLabelImage("apple.jpg");
        assertNotNull(imageLabel);
        assertNotNull(imageLabel.getIcon());
    }
    
    @Test
    void testLoadImageIcon() {
        ImageIcon icon = workingWithImages.loadImageIcon("apple.jpg", 100, 100);
        assertNotNull(icon);
        assertEquals(100, icon.getIconWidth());
        assertEquals(100, icon.getIconHeight());
    }
    
    @Test
    void testPrepareJTextAreaDescription() {
        String description = "This is a test description for a fruit";
        JTextArea textArea = workingWithImages.prepareJTextAreaDescription(description);
        assertNotNull(textArea);
        assertEquals(description, textArea.getText());
        assertFalse(textArea.isEditable());
    }
    
    @Test
    void testPrepareJPanelButtons() {
        JPanel buttonsPanel = workingWithImages.prepareJPanelButtons(
            "APPLE", "Test description", "apple.jpg"
        );
        assertNotNull(buttonsPanel);
        assertTrue(buttonsPanel.getComponentCount() > 0);
    }
    
    @Test
    void testPrepareJButtonViewMore() {
        JButton button = workingWithImages.prepareJButtonViewMore(
            "APPLE", "Test description", "apple.jpg"
        );
        assertNotNull(button);
        assertEquals("View More", button.getText());
    }
    
    @Test
    void testPrepareJButtonFavorite() {
        JButton button = workingWithImages.prepareJButtonFavorite("APPLE");
        assertNotNull(button);
        assertEquals("Add to Favorites", button.getText());
    }
}

