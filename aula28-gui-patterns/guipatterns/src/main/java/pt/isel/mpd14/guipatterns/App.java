package pt.isel.mpd14.guipatterns;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Hello world!
 *
 */
public class App {
    
    
    static class ImageComponent extends JComponent{
        
	private Icon _icon; 
        
	public ImageComponent(Icon i){ 
		_icon = i; 
	} 
	protected void paintComponent(Graphics g) { 
		_icon.paintIcon(this, g, 0, 0); 
	} 
	public int getWidth() { 
		return _icon.getIconWidth(); 
	} 
	public int getHeight() { 
		return _icon.getIconHeight(); 
	} 
	public Dimension getPreferredSize() { 
		return new Dimension(getWidth(), getHeight()); 
	} 
}

    static class SpecialButton extends JButton{

        public SpecialButton(String text) {
            super(text);
        }

        /*
        * Hook Method de JButton
        */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); 
            g.draw3DRect(10, 10, this.getWidth()-20, this.getHeight()-20, true);
        }
        
    }

    public static void main(String[] args) {
        JFrame frm = new JFrame();
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        /*
         * Exemplo de aplicação do padrão de desenho STRATEGY
         */
        //frm.setLayout(new FlowLayout()); // os componentes são dispostos lado a lado com o seu tamanho natural 
        frm.setLayout(new GridLayout(1, 3));
        
        /*
         * Exemplo do COMPOSITE: composição de componentes
         */
        JComponent cmp = new JLabel("Ola mundo:");
        cmp.setBorder(BorderFactory.createBevelBorder(1));
        frm.add(cmp);
        frm.add(new SpecialButton("Click"));
        
        /*
         * Exemplo do Adapter: não podemos adicionar directamente um Icon a uma frame
         * pq não é compatível com Component.
         * Criamos um Adapter que encapsula a funcionalidade de ImageIcon e obedece 
         * à interface JComponet
         */
        frm.add(new JScrollPane(new ImageComponent(new ImageIcon("Study-icon.png"))));
                
        /*
         * Exemplo do Decorator: Acrescenta uma funcionalidade (barras de Scroll) e mantém a interface (JComponet)
         */
        frm.add(new JScrollPane(new JTextArea()));
        frm.add(new JScrollPane(new JList<String>(new String[]{"ola", "isel", "mundo", "xpto"})));
        
        frm.pack();
        frm.setVisible(true);
    }
}
