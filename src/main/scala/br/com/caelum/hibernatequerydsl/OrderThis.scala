package br.com.caelum.hibernatequerydsl

import org.hibernate.Criteria
import org.hibernate.criterion.Order

class OrderThis[T](path:String, val pimped:PimpedCriteria[T]) {
  implicit def criteriaToPimped(partial:Criteria) = new PimpedCriteria[T](partial)

	def asc():PimpedCriteria[T] = {
		pimped.criteria.addOrder(Order.asc(path))
	}
	def desc():PimpedCriteria[T] = {
		pimped.criteria.addOrder(Order.desc(path))
	}

}