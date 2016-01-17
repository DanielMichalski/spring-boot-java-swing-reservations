package pl.dmichalski.reservations.business.ui.shared.model;

import java.util.List;

public abstract class DefaultComboBoxModel<T> extends javax.swing.DefaultComboBoxModel<T> {

    @Override
    public T getSelectedItem() {
        return (T) super.getSelectedItem();
    }

    public void addElements(List<T> elements) {
        elements.forEach(this::addElement);
    }

    public void clear() {
        removeAllElements();
    }
}
