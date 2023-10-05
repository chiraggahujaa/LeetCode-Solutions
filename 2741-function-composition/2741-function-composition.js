var compose = function(functions) {
	return function(x) {
        return functions.reduceRight((val, fn) => fn(val), x);
    }
};