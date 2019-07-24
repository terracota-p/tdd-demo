'use strict';

const apickli = require('apickli');
const {Before} = require('cucumber');

Before(function() {
    this.apickli = new apickli.Apickli('http', 'localhost:8080');
    this.apickli.addRequestHeader('Cache-Control', 'no-cache');
});