package kartikey.saran.myapplication.layout_manager;

import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Context;
public class CustomLayoutManager extends LinearLayoutManager {
    private boolean isScrollEnabled = false;

    public CustomLayoutManager(Context context) {
        super(context);
    }

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        return isScrollEnabled && super.canScrollVertically();
    }
}
