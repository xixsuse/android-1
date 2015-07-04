package com.i906.mpt.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.i906.mpt.MptApplication;
import com.i906.mpt.R;
import com.i906.mpt.extension.ExtensionManager;
import com.i906.mpt.provider.MptInterface;
import com.i906.mpt.util.Utils;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    protected Utils mUtils;

    @Inject
    protected ExtensionManager mExtensionManager;

    @Inject
    protected MptInterface mPrayerInterface;

    @Nullable
    @Bind(R.id.toolbar)
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MptApplication.component(this).inject(this);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
