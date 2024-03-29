package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.util.modifier.ease.IEaseFunction;

/**
 * @author Nicolas Gramlich
 * @since 12:03:22 - 30.08.2010
 */
public class MoveXModifier extends SingleValueSpanShapeModifier {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	public MoveXModifier(final float pDuration, final float pFromX, final float pToX) {
		this(pDuration, pFromX, pToX, null, IEaseFunction.DEFAULT);
	}

	public MoveXModifier(final float pDuration, final float pFromX, final float pToX, final IEaseFunction pEaseFunction) {
		this(pDuration, pFromX, pToX, null, pEaseFunction);
	}

	public MoveXModifier(final float pDuration, final float pFromX, final float pToX, final IEntityModifierListener pEntityModifierListener) {
		super(pDuration, pFromX, pToX, pEntityModifierListener, IEaseFunction.DEFAULT);
	}

	public MoveXModifier(final float pDuration, final float pFromX, final float pToX, final IEntityModifierListener pEntityModifierListener, final IEaseFunction pEaseFunction) {
		super(pDuration, pFromX, pToX, pEntityModifierListener, pEaseFunction);
	}

	protected MoveXModifier(final MoveXModifier pMoveXModifier) {
		super(pMoveXModifier);
	}

	@Override
	public MoveXModifier clone(){
		return new MoveXModifier(this);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	protected void onSetInitialValue(final IEntity pEntity, final float pX) {
		pEntity.setPosition(pX, pEntity.getY());
	}

	@Override
	protected void onSetValue(final IEntity pEntity, final float pPercentageDone, final float pX) {
		pEntity.setPosition(pX, pEntity.getY());
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
