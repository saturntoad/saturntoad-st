package org.anddev.andengine.entity.shape;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.scene.Scene.ITouchArea;

/**
 * @author Nicolas Gramlich
 * @since 13:32:52 - 07.07.2010
 */
public interface IShape extends IEntity, ITouchArea {
	// ===========================================================
	// Final Fields
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	public boolean isCullingEnabled();
	public void setCullingEnabled(final boolean pCullingEnabled);

	public float getWidth();
	public float getHeight();

	public float getBaseWidth();
	public float getBaseHeight();

	public float getWidthScaled();
	public float getHeightScaled();

	public boolean collidesWith(final IShape pOtherShape);

	public void setBlendFunction(final int pSourceBlendFunction, final int pDestinationBlendFunction);
}