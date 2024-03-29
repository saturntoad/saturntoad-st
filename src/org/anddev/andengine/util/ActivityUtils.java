package org.anddev.andengine.util;

import java.util.concurrent.Callable;

import org.anddev.andengine.ui.activity.BaseActivity.CancelledException;
import org.anddev.andengine.util.progress.IProgressListener;
import org.anddev.andengine.util.progress.ProgressCallable;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.Window;
import android.view.WindowManager;

/**
 * @author Nicolas Gramlich
 * @since 18:11:54 - 07.03.2011
 */
public class ActivityUtils {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================
	
	public static void requestFullscreen(final Activity pActivity) {
		final Window window = pActivity.getWindow();
		window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		window.clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		window.requestFeature(Window.FEATURE_NO_TITLE);
	}

	public static <T> void doAsync(final Context pContext, final int pTitleResID, final int pMessageResID, final Callable<T> pCallable, final Callback<T> pCallback) {
		ActivityUtils.doAsync(pContext, pTitleResID, pMessageResID, pCallable, pCallback, null);
	}

	public static <T> void doAsync(final Context pContext, final int pTitleResID, final int pMessageResID, final Callable<T> pCallable, final Callback<T> pCallback, final Callback<Exception> pExceptionCallback) {
		new AsyncTask<Void, Void, T>() {
			private ProgressDialog mPD;
			private Exception mException = null;

			@Override
			public void onPreExecute() {
				this.mPD = ProgressDialog.show(pContext, pContext.getString(pTitleResID), pContext.getString(pMessageResID));
				super.onPreExecute();
			}

			@Override
			public T doInBackground(final Void... params) {
				try {
					return pCallable.call();
				} catch (final Exception e) {
					this.mException = e;
				}
				return null;
			}

			@Override
			public void onPostExecute(final T result) {
				try {
					this.mPD.dismiss();
				} catch (final Exception e) {
					Debug.e("Error", e);
				}

				if(this.isCancelled()) {
					this.mException = new CancelledException();
				}

				if(this.mException == null) {
					pCallback.onCallback(result);
				} else {
					if(pExceptionCallback == null) {
						Debug.e("Error", this.mException);
					} else {
						pExceptionCallback.onCallback(this.mException);
					}
				}

				super.onPostExecute(result);
			}
		}.execute((Void[]) null);
	}

	public static <T> void doProgressAsync(final Context pContext, final int pTitleResID, final ProgressCallable<T> pCallable, final Callback<T> pCallback) {
		ActivityUtils.doProgressAsync(pContext, pTitleResID, pCallable, pCallback, null);
	}

	public static <T> void doProgressAsync(final Context pContext, final int pTitleResID, final ProgressCallable<T> pCallable, final Callback<T> pCallback, final Callback<Exception> pExceptionCallback) {
		new AsyncTask<Void, Integer, T>() {
			private ProgressDialog mPD;
			private Exception mException = null;

			@Override
			public void onPreExecute() {
				this.mPD = new ProgressDialog(pContext);
				this.mPD.setTitle(pTitleResID);
				this.mPD.setIcon(android.R.drawable.ic_menu_save);
				this.mPD.setIndeterminate(false);
				this.mPD.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				this.mPD.show();
				super.onPreExecute();
			}

			@Override
			public T doInBackground(final Void... params) {
				try {
					return pCallable.call(new IProgressListener() {
						@Override
						public void onProgressChanged(final int pProgress) {
							onProgressUpdate(pProgress);
						}
					});
				} catch (final Exception e) {
					this.mException = e;
				}
				return null;
			}

			@Override
			public void onProgressUpdate(final Integer... values) {
				this.mPD.setProgress(values[0]);
			}

			@Override
			public void onPostExecute(final T result) {
				try {
					this.mPD.dismiss();
				} catch (final Exception e) {
					Debug.e("Error", e);
					/* Nothing. */
				}

				if(this.isCancelled()) {
					this.mException = new CancelledException();
				}

				if(this.mException == null) {
					pCallback.onCallback(result);
				} else {
					if(pExceptionCallback == null) {
						Debug.e("Error", this.mException);
					} else {
						pExceptionCallback.onCallback(this.mException);
					}
				}

				super.onPostExecute(result);
			}
		}.execute((Void[]) null);
	}

	public static <T> void doAsync(final Context pContext, final int pTitleResID, final int pMessageResID, final AsyncCallable<T> pAsyncCallable, final Callback<T> pCallback, final Callback<Exception> pExceptionCallback) {
		final ProgressDialog pd = ProgressDialog.show(pContext, pContext.getString(pTitleResID), pContext.getString(pMessageResID));
		pAsyncCallable.call(new Callback<T>() {
			@Override
			public void onCallback(final T result) {
				try {
					pd.dismiss();
				} catch (final Exception e) {
					Debug.e("Error", e);
					/* Nothing. */
				}

				pCallback.onCallback(result);
			}
		}, pExceptionCallback);
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
