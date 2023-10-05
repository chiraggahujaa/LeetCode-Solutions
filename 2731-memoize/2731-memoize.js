/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    const map = new Map();
    return function(...args) {
        let key = "";
        args.forEach(el => key += el + " ");

        if(map.has(key))
            return map.get(key);

        const res = fn(...args);
        map.set(key, res);
        return res;
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */