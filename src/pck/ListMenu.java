package pck;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

/**
 *
 * @author Grácio Macuácua
 */
public class ListMenu<E extends Object> extends JList<E>{

    private final DefaultListModel model;
    private int selectedIndex = -1;
    
    public ListMenu() {
        model = new DefaultListModel();
        setModel(model);
        init();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)){                    
                    int index = locationToIndex(e.getPoint());
                    Object o = model.getElementAt(index);
                    if(o instanceof Model_Menu){
                        Model_Menu menu = (Model_Menu) o;
                        if(menu.getType() == Model_Menu.MenuType.MENU)
                            selectedIndex = index;
                    }else {
                        selectedIndex = index;
                    }
                    repaint();
                }
            }
            
        });
    }
    
    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean selected, boolean focus) {
                Model_Menu data;
                if(value instanceof Model_Menu){
                    data = (Model_Menu) value;
                }else{
                    data = new Model_Menu("", value + "", Model_Menu.MenuType.EMPTY);
                }
                MenuItem item = new MenuItem(data);
                item.setSelected(selectedIndex == index);
                return item;
            }
        };
    }
    
    /**
     * Adiciona os componentes do menu (ícone e nome de cada opção) ao JList
     */
    private void init(){
        addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        addItem(new Model_Menu("criar", "Criar Conta", Model_Menu.MenuType.MENU));
        addItem(new Model_Menu("selecionar", "Selecionar Conta", Model_Menu.MenuType.MENU));
        addItem(new Model_Menu("remover", "Remover Conta", Model_Menu.MenuType.MENU));
        addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        addItem(new Model_Menu("", "Utilitários", Model_Menu.MenuType.TITLE));        
        addItem(new Model_Menu("relatorio", "Gerar Relatório", Model_Menu.MenuType.MENU));
        addItem(new Model_Menu("finalizar", "Finalizar o Programa", Model_Menu.MenuType.MENU));
        addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
    }
    
    /**
     * 
     * @param data Elemento a ser adicionado ao menu
     */
    public void addItem(Model_Menu data){
        model.addElement(data);
    }
    
}
