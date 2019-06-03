/*
 *   Copyright 2019 Benoit LETONDOR
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.benoitletondor.mvp.material.view.impl;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import com.benoitletondor.mvp.core.presenter.Presenter;
import com.benoitletondor.mvp.core.presenter.PresenterFactory;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

@SuppressWarnings("unused")
public abstract class BaseMVPBottomSheetDialogFragment<P extends Presenter<V>, V extends com.benoitletondor.mvp.core.view.View> extends BottomSheetDialogFragment
{
    private final static String TAG = "BaseMVPBottomSheet";

    /**
     * The presenter for this view
     */
    @SuppressWarnings("WeakerAccess")
    @Nullable
    protected P mPresenter;
    /**
     * Is this the first start of the fragment (after onCreate)
     */
    private boolean mFirstStart;

// ------------------------------------------->

    @Override
    @SuppressWarnings("unchecked")
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mFirstStart = true;

        mPresenter = (P) ViewModelProviders.of(this, new ViewModelProvider.Factory()
        {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass)
            {
                return (T) getPresenterFactory().create();
            }

        }).get(ViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        mFirstStart = true;

        super.onViewCreated(view, savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        mFirstStart = true;

        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onStart()
    {
        super.onStart();

        if( mPresenter != null )
        {
            doStart();
        }
    }

    @Override
    public void onStop()
    {
        if( mPresenter != null )
        {
            doStop();
        }

        super.onStop();
    }

// ------------------------------------------->

    /**
     * Call the presenter callbacks for onStart
     */
    @SuppressWarnings("unchecked")
    @VisibleForTesting
    void doStart()
    {
        assert mPresenter != null;

        mPresenter.onViewAttached((V) this);

        mPresenter.onStart(mFirstStart);

        mFirstStart = false;
    }

    /**
     * Call the presenter callbacks for onStop
     */
    @VisibleForTesting
    void doStop()
    {
        assert mPresenter != null;

        mPresenter.onStop();

        mPresenter.onViewDetached();
    }

    /**
     * Get the presenter factory implementation for this view
     *
     * @return the presenter factory
     */
    protected abstract PresenterFactory<P> getPresenterFactory();
}
