package lab4;

/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * An interface for a binary tree, in which each node has at most two children.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * 
 * Simplified for INFO1105/1905/9105:
 *   no checking that position is still valid, no throw declarations
 *   includes a subset of methods from Tree<E>, instead of extending it
 */
public interface BinaryTree<E> {

  /**
   * Returns the Position of p's left child (or null if no child exists).
   *
   * @param p A valid Position within the tree
   * @return the Position of the left child (or null if no child exists)
   */
  Position<E> left(Position<E> p);

  /**
   * Returns the Position of p's right child (or null if no child exists).
   *
   * @param p A valid Position within the tree
   * @return the Position of the right child (or null if no child exists)
   */
  Position<E> right(Position<E> p);

  /**
   * Returns the Position of p's sibling (or null if no sibling exists).
   *
   * @param p A valid Position within the tree
   * @return the Position of the sibling (or null if no sibling exists)
   * @throws IllegalArgumentException if p is not a valid Position for this tree
   */
  Position<E> sibling(Position<E> p);

  /**
   * Returns the root Position of the tree (or null if tree is empty).
   * @return root Position of the tree (or null if tree is empty)
   */
  Position<E> root();

  /**
   * Returns the Position of p's parent (or null if p is root).
   *
   * @param p    A valid Position within the tree
   * @return Position of p's parent (or null if p is root)
   */
  Position<E> parent(Position<E> p);

  /**
   * Returns the number of children of Position p.
   *
   * @param p    A valid Position within the tree
   * @return number of children of Position p
   */
  int numChildren(Position<E> p);

  /**
   * Returns true if Position p has one or more children.
   *
   * @param p    A valid Position within the tree
   * @return true if p has at least one child, false otherwise
   */
  boolean isInternal(Position<E> p);

  /**
   * Returns true if Position p does not have any children.
   *
   * @param p    A valid Position within the tree
   * @return true if p has zero children, false otherwise
   */
  boolean isExternal(Position<E> p);

  /**
   * Returns true if Position p represents the root of the tree.
   *
   * @param p    A valid Position within the tree
   * @return true if p is the root of the tree, false otherwise
   */
  boolean isRoot(Position<E> p);

  /**
   * Returns the number of nodes in the tree.
   * @return number of nodes in the tree
   */
  int size();

  /**
   * Tests whether the tree is empty.
   * @return true if the tree is empty, false otherwise
   */
  boolean isEmpty();
  
}
