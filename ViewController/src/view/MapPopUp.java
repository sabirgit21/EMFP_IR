package view;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.event.DialogEvent;

public class MapPopUp {
    private RichPopup p1;

    public MapPopUp() {
    }

    public void showPopup(DialogEvent dialogEvent) {
        // Add event code here...
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        getP1().show(hints);
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }
}
