/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author BootCamp LP
 */
public class PieceTest {
    
    public PieceTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getTypePiece method, of class Piece.
     */
    @org.junit.jupiter.api.Test
    public void testGetTypePiece() {
        System.out.println("getTypePiece");
        Piece instance = new PieceImpl();
        char expResult = ' ';
        char result = instance.getTypePiece();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTypePiece method, of class Piece.
     */
    @org.junit.jupiter.api.Test
    public void testSetTypePiece() {
        System.out.println("setTypePiece");
        char type = ' ';
        Piece instance = new PieceImpl();
        instance.setTypePiece(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColor method, of class Piece.
     */
    @org.junit.jupiter.api.Test
    public void testGetColor() {
        System.out.println("getColor");
        Piece instance = new PieceImpl();
        char expResult = ' ';
        char result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class Piece.
     */
    @org.junit.jupiter.api.Test
    public void testSetColor() {
        System.out.println("setColor");
        char color = ' ';
        Piece instance = new PieceImpl();
        instance.setColor(color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentSquare method, of class Piece.
     */
    @org.junit.jupiter.api.Test
    public void testGetCurrentSquare() {
        System.out.println("getCurrentSquare");
        Piece instance = new PieceImpl();
        ChessSquare expResult = null;
        ChessSquare result = instance.getCurrentSquare();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentSquare method, of class Piece.
     */
    @org.junit.jupiter.api.Test
    public void testSetCurrentSquare() {
        System.out.println("setCurrentSquare");
        ChessSquare currentSquare = null;
        Piece instance = new PieceImpl();
        instance.setCurrentSquare(currentSquare);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValidMoves method, of class Piece.
     */
    @org.junit.jupiter.api.Test
    public void testSetValidMoves_ArrayList() {
        System.out.println("setValidMoves");
        ArrayList<ChessSquare> ValidMoves = null;
        Piece instance = new PieceImpl();
        instance.setValidMoves(ValidMoves);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValidMoves method, of class Piece.
     */
    @org.junit.jupiter.api.Test
    public void testGetValidMoves() {
        System.out.println("getValidMoves");
        Piece instance = new PieceImpl();
        ArrayList<ChessSquare> expResult = null;
        ArrayList<ChessSquare> result = instance.getValidMoves();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValidMoves method, of class Piece.
     */
    @org.junit.jupiter.api.Test
    public void testSetValidMoves_List() {
        System.out.println("setValidMoves");
        List<ChessSquare> ValidMoves = null;
        Piece instance = new PieceImpl();
        instance.setValidMoves(ValidMoves);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class Piece.
     */
    @org.junit.jupiter.api.Test
    public void testMove() {
        System.out.println("move");
        Piece pieceToMove = null;
        Piece[][] spots = null;
        Piece instance = new PieceImpl();
        ArrayList<ChessSquare> expResult = null;
        ArrayList<ChessSquare> result = instance.move(pieceToMove, spots);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchMate method, of class Piece.
     */
    @org.junit.jupiter.api.Test
    public void testSearchMate() {
        System.out.println("searchMate");
        Piece kingPiece = null;
        Piece matePiece = null;
        Piece[][] spots = null;
        Piece instance = new PieceImpl();
        ArrayList<ChessSquare> expResult = null;
        ArrayList<ChessSquare> result = instance.searchMate(kingPiece, matePiece, spots);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PieceImpl extends Piece {

        public ArrayList<ChessSquare> move(Piece pieceToMove, Piece[][] spots) {
            return null;
        }

        public ArrayList<ChessSquare> searchMate(Piece kingPiece, Piece matePiece, Piece[][] spots) {
            return null;
        }
    }
    
}
