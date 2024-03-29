package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.util.modifier.ease.IEaseFunction;

/**
 * @author Nicolas Gramlich
 * @since 12:04:21 - 30.08.2010
 */
public class MoveYModifier extends SingleValueSpanShapeModifier {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	public MoveYModifier(final float pDuration, final float pFromY, final float pToY) {
		this(pDuration, pFromY, pToY, null, IEaseFunction.DEFAULT);
	}

	public MoveYModifier(final float pDuration, final float pFromY, final float pToY, final IEaseFunction pEaseFunction) {
		this(pDuration, pFromY, pToY, null, pEaseFunction);
	}

	public MoveYModifier(final float pDuration, final float pFromY, final float pToY, final IEntityModifierListener pEntityModifierListener) {
		super(pDuration, pFromY, pToY, pEntityModifierListener, IEaseFunction.DEFAULT);
	}

	public MoveYModifier(final float pDuration, final float pFromY, final float pToY, final IEntityModifierListener pEntityModifierListener, final IEaseFunction pEaseFunction) {
		super(pDuration, pFromY, pToY, pEntityModifierListener, pEaseFunction);
	}

	protected MoveYModifier(final MoveYModifier pMoveYModifier) {
		super(pMoveYModifier);
	}

	@Override
	public MoveYModifier clone(){
		return new MoveYModifier(this);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	protected void onSetInitialValue(final IEntity pEntity, final float pY) {
		pEntity.setPosition(pEntity.getX(), pY);
	}

	@Override
	protected void onSetValue(final IEntity pEntity, final float pPercentageDone, final float pY) {
		pEntity.setPosition(pEntity.getX(), pY);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
