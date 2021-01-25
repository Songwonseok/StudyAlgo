function sleep(ms) {
  var current = Date.now()
  var until = Date.now() + ms
  while (current < until) {
    current = Date.now()
  }
  console.log("pig")
}

console.log('rat')

setTimeout(function () {
  console.log("cat")
}, 3 * 1000)

sleep(5 * 1000)

console.log('dog')

console.log('cow')