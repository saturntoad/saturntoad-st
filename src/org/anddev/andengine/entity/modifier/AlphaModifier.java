package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.util.modifier.ease.IEaseFunction;

/**
 * @author Nicolas Gramlich
 * @since 23:13:01 - 19.03.2010
 */
public class AlphaModifier extends SingleValueSpanShapeModifier {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	public AlphaModifier(final float pDuration, final float pFromAlpha, final float pToAlpha) {
		this(pDuration, pFromAlpha, pToAlpha, null, IEaseFunction.DEFAULT);
	}

	public AlphaModifier(final float pDuration, final float pFromAlpha, final float pToAlpha, final IEaseFunction pEaseFunction) {
		this(pDuration, pFromAlpha, pToAlpha, null, pEaseFunction);
	}

	public AlphaModifier(final float pDuration, final float pFromAlpha, final float pToAlpha, final IEntityModifierListener pEntityModifierListener) {
		super(pDuration, pFromAlpha, pToAlpha, pEntityModifierListener, IEaseFunction.DEFAULT);
	}

	public AlphaModifier(final float pDuration, final float pFromAlpha, final float pToAlpha, final IEntityModifierListener pEntityModifierListener, final IEaseFunction pEaseFunction) {
		super(pDuration, pFromAlpha, pToAlpha, pEntityModifierListener, pEaseFunction);
	}

	protected AlphaModifier(final AlphaModifier pAlphaModifier) {
		super(pAlphaModifier);
	}

	@Override
	public AlphaModifier clone(){
		return new AlphaModifier(this);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	protected void onSetInitialValue(final IEntity pEntity, final float pAlpha) {
		pEntity.setAlpha(pAlpha);
	}

	@Override
	protected void onSetValue(final IEntity pEntity, final float pPercentageDone, final float pAlpha) {
		pEntity.setAlpha(pAlpha);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
