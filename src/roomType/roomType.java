package roomType;

import Entities.Monster;

public class roomType {
    /**defines the Traits of the room:
     * <p>[0]: Are there enemies</p>
     * <p>[1]: Is there a spike trap</p>
     * <p>[2]: Has the spike trap been activated</p>*/
    protected boolean[] traits;
    protected Monster[] enemies;

    public roomType() {
        traits = new boolean[] {Math.random()<0.5, Math.random()<0.5, false};
    }

    public boolean[] getTraits() {
        return traits;
    }
}
