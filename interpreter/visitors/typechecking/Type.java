package interpreter.visitors.typechecking;

public interface Type {
	default Type checkEqual(Type found) throws TypecheckerException {
		if (!equals(found))
			throw new TypecheckerException(found.toString(), toString());
		return this;
	}

	default void checkIsProdType() throws TypecheckerException {
		if (!(this instanceof ProdType))
			throw new TypecheckerException(toString(), ProdType.TYPE_NAME);
	}

	default Type getFstProdType() throws TypecheckerException {
		checkIsProdType();
		return ((ProdType) this).getFstType();
	}

	default Type getSndProdType() throws TypecheckerException {
		checkIsProdType();
		return ((ProdType) this).getSndType();
	}


	//L++
		//returns start Range Type
	default Type getStartRangeType() throws TypecheckerException {
		return ((RangeType) this).getStartType();
	}

		//returns end Range Type
	default Type getEndRangeType() throws TypecheckerException {
		return ((RangeType)this).getEndType();
	}


	// check if the object is a RangeType
	default void checkIsRangeType() throws TypecheckerException {
		if (! (this instanceof RangeType))
			throw new TypecheckerException(toString(), RangeType.TYPE_NAME);
	}
}
