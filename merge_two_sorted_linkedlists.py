
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def merge_two_lists(list1, list2):
    dummy = ListNode()  # Create a dummy node
    tail = dummy  # This will be used to build the new list

    while list1 is not None and list2 is not None:
        if list1.val < list2.val:
            tail.next = list1  # Append list1 node
            list1 = list1.next  # Move to the next node in list1
        else:
            tail.next = list2  # Append list2 node
            list2 = list2.next  # Move to the next node in list2
        tail = tail.next  # Move the tail

    # At this point, at least one of the lists is None
    if list1 is not None:
        tail.next = list1  # Append the remaining nodes from list1
    else:
        tail.next = list2  # Append the remaining nodes from list2

    return dummy.next  # Return the merged list, skipping the dummy node
