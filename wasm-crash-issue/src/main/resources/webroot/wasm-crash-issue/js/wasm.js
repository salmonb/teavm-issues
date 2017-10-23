var main = function() {
    var xhr = new XMLHttpRequest();
    xhr.responseType = "arraybuffer";
    xhr.open("GET", "js/classes.wasm");
    xhr.onload = function() {
        var response = xhr.response;
        if (!response) {
            return;
        }
        var importObj = {};
        WebAssembly.instantiate(response, importObj).then(function(resultObject) {
            //benchmark.instance = resultObject.instance;
            console.log("Initialized")
            //callback();
        }).catch(function(error) {
            console.log("Error : " + error);
        });
    };
    xhr.send();
}