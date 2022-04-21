'use strict';

const path = require('path');
const HtmlPluginWebpack = require('html-webpack-plugin');
//const {CleanWebpackPlugin} = require('clean-webpack-plugin');

module.exports = {
    mode: 'development',
    entry: './app/app.js',
    output: {
        filename: '[name].bundle.js',
        path: path.resolve(__dirname, 'dist'),
        clean: true
    },
    devtool: 'eval-source-map',
    plugins: [
        new HtmlPluginWebpack({
            title: 'EDM GKordyukova',
            template: "./app/index.html",
            inject: true
        }),
        //new CleanWebpackPlugin()
    ],
    resolve: {
        extensions: ['.webpack.js', '.js']
    },
    module: {
        rules: [
            {
                test: /\.html$/,
                loader: 'html-loader',
                exclude: path.resolve("./app/index.html")
            },
            {
                test: /\.css$/,
                loader: 'style-loader'
            },
            {
                test: /\.(png|jpg|svg|gif)$/,
                use: ["file-loader"]
            },
            {
                test: /\.less$/i,
                use: ["style-loader", "css-loader", "less-loader"],
            },
            {
                test: /\.js$/,
                loader: 'babel-loader',
                exclude: /node_modules/
            }
        ]
    }
};