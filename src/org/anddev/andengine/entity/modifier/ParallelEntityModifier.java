package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.util.modifier.ParallelModifier;

/**
 * @author Nicolas Gramlich
 * @since 12:40:31 - 03.09.2010
 */
public class ParallelEntityModifier extends ParallelModifier<IEntity> implements IEntityModifier {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	public ParallelEntityModifier(final IEntityModifier... pEntityModifiers) throws IllegalArgumentException {
		super(pEntityModifiers);
	}

	public ParallelEntityModifier(final IEntityModifierListener pEntityModifierListener, final IEntityModifier... pEntityModifiers) throws IllegalArgumentException {
		super(pEntityModifierListener, pEntityModifiers);
	}

	protected ParallelEntityModifier(final ParallelEntityModifier pParallelShapeModifier) {
		super(pParallelShapeModifier);
	}

	@Override
	public ParallelEntityModifier clone() {
		return new ParallelEntityModifier(this);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
