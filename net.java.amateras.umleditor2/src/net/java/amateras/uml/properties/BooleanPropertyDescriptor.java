package net.java.amateras.uml.properties;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.PropertyDescriptor;

/**
 * boolean
 * 
 * @author Naoki Takezoe
 */
public class BooleanPropertyDescriptor extends PropertyDescriptor {
	
	public BooleanPropertyDescriptor(Object id,String displayName){
		super(id,displayName);
	}
	
    public CellEditor createPropertyEditor(Composite parent) {
        CellEditor editor = new ComboBoxCellEditor(
        		parent, new String[]{"true","false"},SWT.READ_ONLY){
        	public void doSetValue(Object value){
        		if(((Boolean)value).booleanValue()){
        			super.doSetValue(new Integer(0));
        		} else {
        			super.doSetValue(new Integer(1));
        		}
        	}
        	public Object doGetValue(){
        		int selection = ((Integer)super.doGetValue()).intValue();
        		if(selection==0){
        			return new Boolean(true);
        		} else {
        			return new Boolean(false);
        		}
        	}
        };
        
        if (getValidator() != null)
            editor.setValidator(getValidator());
        
        return editor;
    }

	
	
}
