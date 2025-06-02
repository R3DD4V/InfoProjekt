package roomType;

import Entities.Monster;

public class roomType {
    /**defines the Traits of the room:
     * <p>[0]: **/
    protected boolean[] traits;
    protected Monster[] enemies;

    public roomType() {
        traits = new boolean[] {};
    }

    public boolean[] getTraits() {
        return traits;
    }
}
