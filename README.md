# avaj-launcher
42 School -- Java cursus #1

## Overview

The project avaj-launcher aims to introduce Java language basics, through the implementation of a simple aircraft simulation.

The program reads a file passed as a command-line argument. The file contains the number of simulation iterations, and the aircrafts involved, including their initial coordinates.

The program generates a 3 dimensions map, where each point corresponds to a weather condition: SUN, RAIN, FOG or SNOW. Each aircraft reacts differently to each weather:

<ul>
    <li>JetPlane</li>
    <ul>
        <li>SUN - Latitude increases by 10, Height increases by 2</li>
        <li>RAIN - Latitude increases by 5</li>
        <li>FOG - Latitude increases by 1</li>
        <li>SNOW - Height decreases by 7</li>
    </ul>
    <li>Helicopter:</li>
    <ul>
        <li>SUN - Longitude increases by 10, Height increases by 2</li>
        <li>RAIN - Longitude increases by 5</li>
        <li>FOG - Longitude increases by 1</li>
        <li>SNOW - Height decreases by 12</li>
    </ul>
    <li>Balloon:</li>
    <ul>
        <li>SUN - Longitude increases by 2, Height increases by 4</li>
        <li>RAIN - Height decreases by 5</li>
        <li>FOG - Height decreases by 3</li>
        <li>SNOW - Height decreases by 15</li>
    </ul>
</ul>

## Prerequisites

You will need java and javac commands.

## Usage

#### Compile:

<code>make</code>

#### Run:
<code>make run ARG="scenario.txt"</code>

#### Clean:
<code>make clean</code>

## Scenario file format

#### First line:<br>
<code>Number of iterations of the simulation</code>

#### Following lines:
<code>type</code> <code>name</code> <code>longitude</code> <code>latitude</code> <code>height</code>

###### Arguments:

<code>Number of iterations of the simulation</code>: _integer_<br>
<code>type</code>: _string_ (<code>Helicopter</code>, <code>JetPlane</code> or <code>Balloon</code>)<br>
<code>name</code>: _string_<br>
<code>longitude</code>, <code>latitude</code>, <code>height</code>: _integer_. Intial position. If <code>height</code> is 0, the AirCraft lands.


## What I learned

<ul>
<li>Reading a UML class diagram</li>
<li>Object-oriented design patterns: Singleton, Factory, Observer</li>
<li>Java syntax</li>
</ul>