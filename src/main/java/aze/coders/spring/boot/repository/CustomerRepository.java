package aze.coders.spring.boot.repository;

import aze.coders.spring.boot.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Page<Customer> findAllByOrderById(Pageable pageable);
    List<Customer> findByName(String nm);

    List<Customer> findByNameAndAddress(String name, String address);

    List<Customer> findByNameOrAddress(String name, String address);

    List<Customer> findByOrderByNameAsc();

    List<Customer> findByIdGreaterThanEqual(Long id);

    List<Customer> findByIdLessThanEqual(Long id);

    List<Customer> findTop10ByOrderByIdDesc();

    List<Customer> findByIdBetween(Long id1, Long id2);

    @Query("select c from Customer c where length(c.address) >?2 and c.name =?1")
    List<Customer> findAddressByIndex(String name, Integer addressLength);

    @Query(value = "select c from Customer c where length(c.address) >:addr and c.name =:name")
    List<Customer> findAddressByName(String name, @Param("addr") Integer addressLength);

    @Query(value = "select * from customers c where length(c.address) >:addr and c.customer_name =:name", nativeQuery = true)
    List<Customer> findAddressByNative(String name, @Param("addr") Integer addressLength);

    void deleteAllByName(String name);

    @Modifying
    @Query("delete from Customer where length(name)>?1 ")
    @Transactional
    void deleteNameByLength(Integer nameLength);
}
