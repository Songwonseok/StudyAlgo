function solution(cacheSize, cities) {
  let cache = [];

  const answer = cities.map(city => city.toUpperCase())
    .reduce((acc, city) => {
      const beginIndex = cache.length - 1;
      const endIndex = beginIndex - cacheSize + 1;

      for (let i = beginIndex; i >= 0 && i >= endIndex; i--) {
        if (cache[i] === city) {
          cache.splice(i, 1);
          cache.push(city);
          return acc + 1;
        }
      }
      cache.push(city);
      return acc + 5;
    }, 0);

  return answer;
}
