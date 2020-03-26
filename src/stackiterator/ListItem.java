/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackiterator;

/**
 *
 * @author kamaj
 */
public class ListItem {

        private	String data;
        private int index;

        public ListItem() {
        }
        public String getData() {
                return data;
        }
        public void setData(String aData) {
                data = aData;
        }

        public void setIndex(int i) {
                index = i;
        }
        public int getIndex() {
                return index;
        }
}
