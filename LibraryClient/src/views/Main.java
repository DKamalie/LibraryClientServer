/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import libraryclientupdate.LibraryClient;


public class Main {
    public static void main(String[] args) {
        new HomeGUI().setGUI();

        LibraryClient.makeConnection();
        LibraryClient.getStreams();
    }
}
